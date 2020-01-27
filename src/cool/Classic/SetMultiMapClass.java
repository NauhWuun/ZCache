package cool.Classic;

import java.io.Serializable;

import cool.External.MultiMap;

public class SetMultiMapClass<K, V> implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 1184364687031130822L;
    private MultiMap<K, V> hCache;

    public SetMultiMapClass(MultiMap<K, V> value) {
        set(value);
    }

    private void set(MultiMap<K, V> value) {
        this.hCache = value;
    }

    public MultiMap<K, V> get() {
        return hCache;
    }

    public String toString() {
        return "[" + SetMultiMapClass.class + "]" + "\r\n";
    }
}