package cool.Classic;

import java.io.Serializable;

public class FloatClass implements Serializable 
{
    /**
     *
     */
    private static final long serialVersionUID = 6646290437944931692L;
    private Float values;

    public FloatClass() { 
        this(Float.parseFloat("0.0"));
    }

    public FloatClass(Float value) {
        set(value);
    }

    private void set(Float value) {
        this.values = value;
    }

    public Float get() {
        return values;
    }

    public String toString() {
        return "[" + FloatClass.class + "]" + "\r\n";
    }
}