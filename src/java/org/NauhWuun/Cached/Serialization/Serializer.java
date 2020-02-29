package org.NauhWuun.Cached.Serialization;

public interface Serializer
{
    public Object read(byte[] inBytes);
    public byte[] write(Object obj);
}