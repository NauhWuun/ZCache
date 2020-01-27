package cool.Classic;

import java.io.Serializable;

public class GeoClass implements Serializable 
{
    /**
     *
     */
    private static final long serialVersionUID = -1558332586792596555L;
    private String values;

    public GeoClass() {
        set(String.valueOf("127.0.0.1"));
    }

    public GeoClass(String value) {
        set(value);
    }

    private void set(String value) {
        this.values = value;
    }

    public String get() {
        return values;
    }

    public String toString() {
        return "[" + GeoClass.class + "]" + "\r\n";
    }
}