package cool.Classic;

import java.io.Serializable;

import cool.External.HibernateCache;

public class HibernateCacheClass implements Serializable 
{
    /**
     *
     */
    private static final long serialVersionUID = -421325768472696694L;
    private HibernateCache hCache;

    public HibernateCacheClass(HibernateCache value) {
        set(value);
    }

    private void set(HibernateCache value) {
        this.hCache = value;
    }

    public HibernateCache get() {
        return hCache;
    }

    public String toString() {
        return "[" + HibernateCacheClass.class + "]" + "\r\n";
    }
}