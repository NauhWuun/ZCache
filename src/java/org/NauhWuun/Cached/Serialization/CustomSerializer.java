package org.NauhWuun.Cached.Serialization;

public class CustomSerializer implements Serializer
{
    @Override
    public Object read(byte[] inBytes) {
        return null;
    }

    @Override
    public byte[] write(Object obj) {
        return new byte[0];
    }
}