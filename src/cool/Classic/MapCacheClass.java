package cool.Classic;

import java.io.Serializable;

import cool.External.MapCache;

public class MapCacheClass<K, V> implements Serializable 
{
    /**
     *
     */
    private static final long serialVersionUID = 3553392527067749647L;
    private MapCache<K, V> values;

    public MapCacheClass(MapCache<K, V> value) {
        set(value);
    }

    private void set(MapCache<K, V> value) {
        this.values = value;
    }

    public MapCache<K, V> get() {
        return values;
    }

    public String toString() {
        return "[" + MapCacheClass.class + "]" + "\r\n";
    }
}