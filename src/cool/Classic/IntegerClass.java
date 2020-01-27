package cool.Classic;

import java.io.Serializable;

public class IntegerClass implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = -3380983215507650115L;
    private Integer values;

    public IntegerClass() { 
        this(Integer.parseInt("0"));
    }

    public IntegerClass(Integer value) {
        set(value);
    }

    private void set(Integer value) {
        this.values = value;
    }

    public Integer get() {
        return values;
    }

    public String toString() {
        return "[" + IntegerClass.class + "]" + "\r\n";
    }
}