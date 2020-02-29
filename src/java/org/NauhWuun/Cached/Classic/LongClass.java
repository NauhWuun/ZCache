package org.NauhWuun.Cached.Classic;

import java.io.Serializable;

public class LongClass implements Serializable 
{
    /**
     *
     */
    private static final long serialVersionUID = -8960570390827448222L;
    private Long values;

    public LongClass() { 
        this(Long.parseLong("0"));
    }

    public LongClass(Long value) {
        set(value);
    }

    private void set(Long value) {
        this.values = value;
    }

    public Long get() {
        return values;
    }

    public String toString() {
        return "[" + LongClass.class + "]" + "\r\n";
    }
}