package org.NauhWuun.Cached.Classic;

import java.io.Serializable;
import java.util.Map;

public class MapCacheClass<K, V> implements Serializable 
{
    /**
     *
     */
    private static final long serialVersionUID = 3553392527067749647L;
    private Map<K, V> values;

    public MapCacheClass(Map<K, V> value) {
        set(value);
    }

    private void set(Map<K, V> value) {
        this.values = value;
    }

    public Map<K, V> get() {
        return values;
    }

    public String toString() {
        return "[" + MapCacheClass.class + "]" + "\r\n";
    }
}