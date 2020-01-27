package cool.Classic;

import java.io.Serializable;

public class DoubleClass implements Serializable 
{
    /**
     *
     */
    private static final long serialVersionUID = 1330413447104031321L;
    private Double values;

    public DoubleClass() { 
        this(Double.parseDouble("0.00"));
    }

    public DoubleClass(Double value) {
        set(value);
    }

    private void set(Double value) {
        this.values = value;
    }

    public Double get() {
        return values;
    }

    public String toString() {
        return "[" + DoubleClass.class + "]" + "\r\n";
    }
}