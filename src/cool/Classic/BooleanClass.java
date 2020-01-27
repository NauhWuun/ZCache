package cool.Classic;

import java.io.Serializable;

public class BooleanClass implements Serializable 
{
    /**
     *
     */
    private static final long serialVersionUID = -629745524040403039L;
    private Boolean values;

    public BooleanClass() { 
        this(Boolean.parseBoolean("true"));
    }

    public BooleanClass(Boolean value) {
        set(value);
    }

    private void set(Boolean value) {
        this.values = value;
    }

    public Boolean get() {
        return values;
    }

    public String toString() {
        return "[" + BooleanClass.class + "]" + "\r\n";
    }
}