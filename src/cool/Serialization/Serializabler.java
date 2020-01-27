package cool.Serialization;

interface Serializer
{
    public Object read(byte[] inBytes);
    public byte[] write(Object obj);
}