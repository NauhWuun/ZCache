package cool.Classic;

import java.io.Serializable;

import antlr.collections.List;

public class ListMultiMapClass<K, V> implements Serializable 
{
    /**
     *
     */
    private static final long serialVersionUID = -2772044646058930471L;
    private List<K, V> maps;

    public ListMultiMapClass(List<K, V> value) {
        set(value);
    }

    private void set(List<K, V> value) {
        this.maps = value;
    }

    public List<K, V> get() {
        return maps;
    }

    public String toString() {
        return "[" + ListMultiMapClass.class + "]" + "\r\n";
    }
}