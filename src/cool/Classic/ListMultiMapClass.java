package cool.Classic;

import java.io.Serializable;

import cool.External.ListMultiMap;

public class ListMultiMapClass<K, V> implements Serializable 
{
    /**
     *
     */
    private static final long serialVersionUID = -2772044646058930471L;
    private Map<K, V> maps;

    public ListMultiMapClass(Map<K, V> value) {
        set(value);
    }

    private void set(Map<K, V> value) {
        this.maps = value;
    }

    public Map<K, V> get() {
        return maps;
    }

    public String toString() {
        return "[" + ListMultiMapClass.class + "]" + "\r\n";
    }
}