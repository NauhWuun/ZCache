package cool.Classic;

import java.io.Serializable;

import cool.External.Geo;

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
        this.values = geo_1;
    }

    public String get() {
        return values;
    }

    public String toString() {
        return "[" + GeoClass.class + "]" + "\r\n";
    }
}