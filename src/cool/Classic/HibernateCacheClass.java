package cool.Classic;

import java.io.Serializable;

import cool.External.HibernateCache;

public class HibernateCacheClass implements Serializable 
{
    /**
     *
     */
    private static final long serialVersionUID = -421325768472696694L;
    private byte[] hCache;

    public HibernateCacheClass(byte[] value) {
        set(value);
    }

    private void set(byte[] value) {
        this.hCache = value;
    }

    public byte[] get() {
        return hCache;
    }

    public String toString() {
        return "[" + HibernateCacheClass.class + "]" + "\r\n";
    }
}