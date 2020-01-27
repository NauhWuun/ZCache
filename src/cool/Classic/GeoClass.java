package cool.Classic;

import java.io.Serializable;

import cool.External.Geo;

public class GeoClass implements Serializable 
{
    /**
     *
     */
    private static final long serialVersionUID = -1558332586792596555L;
    private Geo values;

    public GeoClass() {
        set(new Geo());
    }

    public GeoClass(Geo value) {
        set(value);
    }

    private void set(Geo value) {
        this.values = value;
    }

    public Geo get() {
        return values;
    }

    public String toString() {
        return "[" + GeoClass.class + "]" + "\r\n";
    }
}