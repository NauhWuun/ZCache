package cool.Classic;

import java.io.Serializable;

import cool.External.MultiSet;

public class MultiSetClass<T> implements Serializable 
{
    /**
     *
     */
    private static final long serialVersionUID = -1134526908326779600L;
    private MultiSet<T> hCache;

    public MultiSetClass(MultiSet<T> value) {
        set(value);
    }

    private void set(MultiSet<T> value) {
        this.hCache = value;
    }

    public MultiSet<T> get() {
        return hCache;
    }

    public String toString() {
        return "[" + MultiSetClass.class + "]" + "\r\n";
    }
}