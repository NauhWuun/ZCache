package cool.Classic;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongClass implements Serializable 
{
    /**
     *
     */
    private static final long serialVersionUID = -330893883887309217L;
    private AtomicLong values;

    public AtomicLongClass() { 
        this(new AtomicLong());
    }

    public AtomicLongClass(AtomicLong value) {
        set(value);
    }

    private void set(AtomicLong value) {
        this.values = value;
    }

    public AtomicLong get() {
        return values;
    }

    public String toString() {
        return "[" + AtomicLongClass.class + "]" + "\r\n";
    }
}