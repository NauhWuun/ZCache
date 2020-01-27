package cool.Serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TypeSerializer implements Serializabler
{
    @Override
    public static Object read(byte[] inBytes) {
        ByteArrayInputStream bis = new ByteArrayInputStream(inBytes);
        ObjectInput in = null;
        Object obj = null;

        try {
            in = new ObjectInputStream(bis);
            obj = (Object) in.readObject();
        } catch(IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException ex) {
            }
        }

        return obj;
    }

    @Override
    public static byte[] write(Object obj) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        byte[] outBytes = { 0x0 };

        try {
            out = new ObjectOutputStream(bos);   
            out.writeObject(obj);
            out.flush();
            outBytes = bos.toByteArray();
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
            } catch (IOException ex) {
            }
        }

        return outBytes;
    }
}