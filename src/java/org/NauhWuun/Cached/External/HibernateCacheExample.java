package org.NauhWuun.Cached.External;

 import java.io.*;
//import java.math.BigDecimal;
//import java.math.BigInteger;
//import java.util.Date;
//
//import org.hibernate.AssertionFailure;
//import org.hibernate.HibernateException;
//import org.hibernate.Interceptor;
//import org.hibernate.cache.spi.entry.CacheEntry;
//import org.hibernate.engine.SessionImplementor;
//import org.hibernate.event.EventSource;
//import org.hibernate.event.PreLoadEvent;
//import org.hibernate.event.PreLoadEventListener;
//import org.hibernate.persister.entity.EntityPersister;
//import org.hibernate.type.TypeHelper;
//import org.hibernate.util.ArrayHelper;
//import org.msgpack.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.xerial.snappy.Snappy;
//import org.xerial.snappy.SnappyException;

/**
 * A cached instance of a persistent class
 *
 * @author Gavin King
 */
public final class HibernateCacheExample implements Serializable
{

//            } else if (3 == flag) {
//            state = pac.unpackInt();
//        } else if (4 == flag) {
//            state = pac.unpackLong();
//        } else if (5 == flag) {
//            state = pac.unpackFloat();
//        } else if (6 == flag) {
//            state = pac.unpackDouble();
//        } else if (7 == flag) {
//            state = pac.unpackBigInteger();
//        } else if (8 == flag) {
//            state = new BigDecimal(pac.unpackString());
//        } else if (9 == flag) {
//            state = pac.unpackBoolean();
//        } else if (10 == flag) {
//            state = new Date(pac.unpackLong());
//        } else if (11 == flag) {
//            String enumClass = pac.unpackString();
//            try {
//                state = (Serializable) Class.forName(enumClass).getEnumConstants()[pac.unpackInt()];
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//        } else if (99 == flag) {
//            state = (Serializable) deserialize(pac.unpackByteArray());
//        }
//        return state;
//    }
//
//    public static byte[] compressFastLZ(byte[] in) {
////        byte[] buffer  = new byte[in.length];
////        int outlen = 0;
////        try {
////            outlen = jfastLz.fastlzCompress(in, 0, in.length, buffer, 0, buffer.length);
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        byte[] out = new byte[outlen + 4];
////        System.arraycopy(intToByteArray(in.length), 0, out, 0, 4);
////        System.arraycopy(buffer, 0, out, 4, outlen);
////        return out;
//        byte[] compressed = null;
//        try {
//            compressed = Snappy.compress(in);
//        } catch (SnappyException e) {
//            log.warn("", e);
//        }
//        return compressed;
//    }
//
//    public static byte[] decompressFastLZ(byte[] in) {
////        int originalbufferLength = byteArrayToInt(in);
////        byte[] buffer = new byte[originalbufferLength];
////        jfastLz.fastlzDecompress(in, 4, in.length - 4, buffer, 0, buffer.length);
////        return buffer;
//        byte[] decompressed = null;
//        try {
//            decompressed = Snappy.uncompress(in);
//        } catch (SnappyException e) {
//            log.warn("", e);
//        }
//        return decompressed;
//    }
//
//    public static final byte[] intToByteArray(int value) {
//        return new byte[] { (byte) (value >>> 24), (byte) (value >>> 16), (byte) (value >>> 8), (byte) value };
//    }
//
//    public static final int byteArrayToInt(byte[] b) {
//        return (b[0] << 24) + ((b[1] & 0xFF) << 16) + ((b[2] & 0xFF) << 8) + (b[3] & 0xFF);
//    }
//
//    /**
//     * Get the bytes representing the given serialized object.
//     */
//    protected byte[] serialize(Object o) {
//        if (o == null) {
//            throw new NullPointerException("Can't serialize null");
//        }
//        byte[] rv = null;
//        try {
//            ByteArrayOutputStream bos = new ByteArrayOutputStream();
//            ObjectOutputStream os = new ObjectOutputStream(bos);
//            os.writeObject(o);
//            os.close();
//            bos.close();
//            rv = bos.toByteArray();
//        } catch (IOException e) {
//            log.warn("", e);
//        }
//        return rv;
//    }
//
//    /**
//     * Get the object represented by the given serialized bytes.
//     */
//    protected Object deserialize(byte[] in) {
//        Object rv = null;
//        try {
//            if (in != null) {
//                ByteArrayInputStream bis = new ByteArrayInputStream(in);
//                ObjectInputStream is = new ObjectInputStream(bis);
//                rv = is.readObject();
//                is.close();
//                bis.close();
//            }
//        } catch (IOException e) {
//            log.warn("", e);
//        } catch (ClassNotFoundException e) {
//            log.warn("", e);
//        }
//        return rv;
//    }
}