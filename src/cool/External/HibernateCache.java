package cool.External;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import org.hibernate.AssertionFailure;
import org.hibernate.HibernateException;
import org.hibernate.Interceptor;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.event.EventSource;
import org.hibernate.event.PreLoadEvent;
import org.hibernate.event.PreLoadEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.type.TypeHelper;
import org.hibernate.util.ArrayHelper;
import org.msgpack.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xerial.snappy.Snappy;
import org.xerial.snappy.SnappyException;

/**
 * A cached instance of a persistent class
 *
 * @author Gavin King
 */
public final class HibernateCache implements Serializable, MessagePackable, MessageUnpackable
{
    private static final Logger log = LoggerFactory.getLogger(CacheEntry.class);

	private Serializable[] disassembledState;
	private String subclass;
	private boolean lazyPropertiesAreUnfetched;
	private Object version;
	
	public String getSubclass() {
		return subclass;
	}
	
	public boolean areLazyPropertiesUnfetched() {
		return lazyPropertiesAreUnfetched;
	}

    public HibernateCache() {

    }

	public HibernateCache(
			final Object[] state, 
			final EntityPersister persister, 
			final boolean unfetched, 
			final Object version,
			final SessionImplementor session, 
			final Object owner) 
	throws HibernateException {
		//disassembled state gets put in a new array (we write to cache by value!)
		this.disassembledState = TypeHelper.disassemble(
				state, 
				persister.getPropertyTypes(), 
				persister.isLazyPropertiesCacheable() ? 
					null : persister.getPropertyLaziness(),
				session, 
				owner 
			);
		subclass = persister.getEntityName();
		lazyPropertiesAreUnfetched = unfetched || !persister.isLazyPropertiesCacheable();
		this.version = version;
	}
	
	public Object getVersion() {
		return version;
	}

	HibernateCache(Serializable[] state, String subclass, boolean unfetched, Object version) {
		this.disassembledState = state;
		this.subclass = subclass;
		this.lazyPropertiesAreUnfetched = unfetched;
		this.version = version;
	}

	public Object[] assemble(
			final Object instance, 
			final Serializable id, 
			final EntityPersister persister, 
			final Interceptor interceptor, 
			final EventSource session) 
	throws HibernateException {

		if ( !persister.getEntityName().equals(subclass) ) {
			throw new AssertionFailure("Tried to assemble a different subclass instance");
		}

		return assemble(disassembledState, instance, id, persister, interceptor, session);

	}

	private static Object[] assemble(
			final Serializable[] values, 
			final Object result, 
			final Serializable id, 
			final EntityPersister persister, 
			final Interceptor interceptor, 
			final EventSource session) throws HibernateException {
			
		//assembled state gets put in a new array (we read from cache by value!)
		Object[] assembledProps = TypeHelper.assemble(
				values, 
				persister.getPropertyTypes(), 
				session, result 
			);

		//persister.setIdentifier(result, id); //before calling interceptor, for consistency with normal load

		//TODO: reuse the PreLoadEvent
		PreLoadEvent preLoadEvent = new PreLoadEvent( session )
				.setEntity(result)
				.setState(assembledProps)
				.setId(id)
				.setPersister(persister);
		
		PreLoadEventListener[] listeners = session.getListeners().getPreLoadEventListeners();
		for ( PreLoadEventListener listener : listeners ) {
			listener.onPreLoad( preLoadEvent );
		}
		
		persister.setPropertyValues( 
				result, 
				assembledProps, 
				session.getEntityMode() 
			);

		return assembledProps;
	}

    public Serializable[] getDisassembledState() {
	    // todo: this was added to support initializing an entity's EntityEntry snapshot during reattach;
	    // this should be refactored to instead expose a method to assemble a EntityEntry based on this
	    // state for return.
	    return disassembledState;
    }

	public String toString() {
		return "CacheEntry(" + subclass + ')' + 
				ArrayHelper.toString(disassembledState);
	}

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(subclass);
        out.writeBoolean(lazyPropertiesAreUnfetched);
        out.writeObject(version);

        int length = disassembledState.length;
        out.writeInt(length);
        for (int i = 0; i < length; i++) {
            Serializable state = disassembledState[i];
            if (null == state) {
                out.writeShort(0);
            } else if (state instanceof String) {
                String string = (String) state;
                if (string.length() > 512) {
                    out.writeShort(1);
                    byte[] compressedBytes = compressFastLZ(string.getBytes());
                    out.writeInt(compressedBytes.length);
                    out.write(compressedBytes);
                } else {
                    out.writeShort(2);
                    out.writeUTF(string);
                }
            } else if (state instanceof Integer) {
                out.writeShort(3);
                out.writeInt((Integer) state);
            } else if (state instanceof Long) {
                out.writeShort(4);
                out.writeLong((Long) state);
            } else if (state instanceof Boolean) {
                out.writeShort(5);
                out.writeBoolean((Boolean) state);
            } else if (state instanceof Date) {
                out.writeShort(6);
                out.writeLong(((Date) state).getTime());
            } else if (state instanceof Enum) {
                out.writeShort(8);
                out.writeUTF(state.getClass().getName());
                out.writeInt(((Enum)state).ordinal());
            } else {
                out.writeShort(9);
                out.writeObject(state);
            }
        }
        // out.writeObject(disassembledState);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        subclass = in.readUTF();
        lazyPropertiesAreUnfetched = in.readBoolean();
        version = in.readObject();

        int length = in.readInt();
        disassembledState = new Serializable[length];
        for (int i = 0; i < length; i++) {
            short flag = in.readShort();
            if (0 == flag) {
                disassembledState[i] = null;
            } else if (1 == flag) {
                byte[] bytes = new byte[in.readInt()];
                in.read(bytes);
                disassembledState[i] = new String(decompressFastLZ(bytes));
            } else if (2 == flag) {
                disassembledState[i] = in.readUTF();
            } else if (3 == flag) {
                disassembledState[i] = in.readInt();
            } else if (4 == flag) {
                disassembledState[i] = in.readLong();
            } else if (5 == flag) {
                disassembledState[i] = in.readBoolean();
            } else if (6 == flag) {
                disassembledState[i] = new Date(in.readLong());
            } else if (8 == flag) {
                String enumClass = in.readUTF();
                try {
                    disassembledState[i] = (Serializable) Class.forName(enumClass).getEnumConstants()[in.readInt()];
                } catch (ClassNotFoundException e) {
                    log.warn("", e);
                }
            } else if (9 == flag) {
                disassembledState[i] = (Serializable) in.readObject();
            }
        }
        // disassembledState = (Serializable[]) in.readObject();
    }

    public void messagePack(Packer pk) throws IOException {
        pk.packString(subclass);
        pk.packBoolean(lazyPropertiesAreUnfetched);
        packSerializable(pk, (Serializable) version);

        int length = disassembledState.length;
        pk.packInt(length);
        for (int i = 0; i < length; i++) {
            Serializable state = disassembledState[i];
            packSerializable(pk, state);
        }

    }

    private void packSerializable(Packer pk, Serializable state) throws IOException {
        if (null == state) {
            pk.packShort((short) 0);
        } else if (state instanceof String) {
            String string = (String) state;
            if (string.length() > 512) {
                pk.packShort((short) 1);
                byte[] compressedBytes = compressFastLZ(string.getBytes());
                pk.packInt(compressedBytes.length);
                pk.packByteArray(compressedBytes);
            } else {
                pk.packShort((short) 2);
                pk.packString(string);
            }
        } else if (state instanceof Integer) {
            pk.packShort((short) 3);
            pk.packInt((Integer) state);
        } else if (state instanceof Long) {
            pk.packShort((short) 4);
            pk.packLong((Long) state);
        } else if (state instanceof Float) {
            pk.packShort((short) 5);
            pk.packFloat((Float) state);
        } else if (state instanceof Double) {
            pk.packShort((short) 6);
            pk.packDouble((Long) state);
        } else if (state instanceof BigInteger) {
            pk.packShort((short) 7);
            pk.packBigInteger((BigInteger) state);
        } else if (state instanceof BigDecimal) {
            pk.packShort((short) 8);
            pk.packString(((BigDecimal) state).toString());
        } else if (state instanceof Boolean) {
            pk.packShort((short) 9);
            pk.packBoolean((Boolean) state);
        } else if (state instanceof Date) {
            pk.packShort((short) 10);
            pk.packLong(((Date) state).getTime());
        } else if (state instanceof Enum) {
            pk.packShort((short) 11);
            pk.packString(state.getClass().getName());
            pk.packInt(((Enum) state).ordinal());
        } else {
            pk.packShort((short) 99);
            pk.packByteArray(serialize(state));
        }
    }

    public void messageUnpack(Unpacker pac) throws IOException, MessageTypeException {
        subclass = pac.unpackString();
        lazyPropertiesAreUnfetched = pac.unpackBoolean();
        version = (Serializable) unpackSerializable(pac);

        int length = pac.unpackInt();
        disassembledState = new Serializable[length];
        for (int i = 0; i < length; i++) {
            disassembledState[i] = unpackSerializable(pac);
        }
    }

    private Serializable unpackSerializable(Unpacker pac) throws IOException {
        short flag = pac.unpackShort();
        Serializable state = null;
        if (0 == flag) {
            state = null;
        } else if (1 == flag) {
            byte[] bytes = new byte[pac.unpackInt()];
            bytes = pac.unpackByteArray();
            state = new String(decompressFastLZ(bytes));
        } else if (2 == flag) {
            state = pac.unpackString();
        } else if (3 == flag) {
            state = pac.unpackInt();
        } else if (4 == flag) {
            state = pac.unpackLong();
        } else if (5 == flag) {
            state = pac.unpackFloat();
        } else if (6 == flag) {
            state = pac.unpackDouble();
        } else if (7 == flag) {
            state = pac.unpackBigInteger();
        } else if (8 == flag) {
            state = new BigDecimal(pac.unpackString());
        } else if (9 == flag) {
            state = pac.unpackBoolean();
        } else if (10 == flag) {
            state = new Date(pac.unpackLong());
        } else if (11 == flag) {
            String enumClass = pac.unpackString();
            try {
                state = (Serializable) Class.forName(enumClass).getEnumConstants()[pac.unpackInt()];
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else if (99 == flag) {
            state = (Serializable) deserialize(pac.unpackByteArray());
        }
        return state;
    }

    public static byte[] compressFastLZ(byte[] in) {
//        byte[] buffer  = new byte[in.length];
//        int outlen = 0;
//        try {
//            outlen = jfastLz.fastlzCompress(in, 0, in.length, buffer, 0, buffer.length);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        byte[] out = new byte[outlen + 4];
//        System.arraycopy(intToByteArray(in.length), 0, out, 0, 4);
//        System.arraycopy(buffer, 0, out, 4, outlen);
//        return out;
        byte[] compressed = null;
        try {
            compressed = Snappy.compress(in);
        } catch (SnappyException e) {
            log.warn("", e);
        }
        return compressed;
    }

    public static byte[] decompressFastLZ(byte[] in) {
//        int originalbufferLength = byteArrayToInt(in);
//        byte[] buffer = new byte[originalbufferLength];
//        jfastLz.fastlzDecompress(in, 4, in.length - 4, buffer, 0, buffer.length);
//        return buffer;
        byte[] decompressed = null;
        try {
            decompressed = Snappy.uncompress(in);
        } catch (SnappyException e) {
            log.warn("", e);
        }
        return decompressed;
    }

    public static final byte[] intToByteArray(int value) {
        return new byte[] { (byte) (value >>> 24), (byte) (value >>> 16), (byte) (value >>> 8), (byte) value };
    }

    public static final int byteArrayToInt(byte[] b) {
        return (b[0] << 24) + ((b[1] & 0xFF) << 16) + ((b[2] & 0xFF) << 8) + (b[3] & 0xFF);
    }

    /**
     * Get the bytes representing the given serialized object.
     */
    protected byte[] serialize(Object o) {
        if (o == null) {
            throw new NullPointerException("Can't serialize null");
        }
        byte[] rv = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(bos);
            os.writeObject(o);
            os.close();
            bos.close();
            rv = bos.toByteArray();
        } catch (IOException e) {
            log.warn("", e);
        }
        return rv;
    }


    /**
     * Get the object represented by the given serialized bytes.
     */
    protected Object deserialize(byte[] in) {
        Object rv = null;
        try {
            if (in != null) {
                ByteArrayInputStream bis = new ByteArrayInputStream(in);
                ObjectInputStream is = new ObjectInputStream(bis);
                rv = is.readObject();
                is.close();
                bis.close();
            }
        } catch (IOException e) {
            log.warn("", e);
        } catch (ClassNotFoundException e) {
            log.warn("", e);
        }
        return rv;
    }
}