package org.NauhWuun.Cached.Classic;

import java.io.Serializable;

public class StringClass implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = -3438405104303347317L;
    private String values;

    public StringClass() { 
        this(String.valueOf(""));
    }

    public StringClass(String value) {
        set(value);
    }

    private void set(String value) {
        this.values = value;
    }

    public String get() {
        return values;
    }

    public String toString() {
        return "[" + StringClass.class + "]" + "\r\n";
    }
}