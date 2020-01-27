package cool.Classic;

import java.io.Serializable;

import cool.External.MultiMap;

public class SetMultiMapClass<K, V> implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 1184364687031130822L;
    private Map<K, V> values;

    public SetMultiMapClass(Map<K, V> value) {
        set(value);
    }

    private void set(Map<K, V> value) {
        this.values = value;
    }

    public Map<K, V> get() {
        return values;
    }

    public String toString() {
        return "[" + SetMultiMapClass.class + "]" + "\r\n";
    }
}