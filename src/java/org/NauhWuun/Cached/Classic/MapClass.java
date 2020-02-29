package org.NauhWuun.Cached.Classic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class MapClass<K, V> implements Serializable 
{
    /**
     *
     */
    private static final long serialVersionUID = -374014066724802391L;
    private Map<K, V> values;

    public MapClass() { 
        this(new HashMap<K, V>());
    }

    public MapClass(Map<K, V> value) {
        set(value);
    }

    private void set(Map<K, V> value) {
        this.values = value;
    }

    public Map<K, V> get() {
        return values;
    }

    public String toString() {
        return "[" + MapClass.class + "]" + "\r\n";
    }
}