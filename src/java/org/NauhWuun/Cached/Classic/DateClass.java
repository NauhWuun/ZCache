package org.NauhWuun.Cached.Classic;

import java.io.Serializable;
import java.util.Date;

public class DateClass implements Serializable 
{
    /**
     *
     */
    private static final long serialVersionUID = -1404227544857742814L;
    private Date values;

    public DateClass() { 
        this(new Date());
    }

    public DateClass(Date value) {
        set(value);
    }

    private void set(Date value) {
        this.values = value;
    }

    public Date get() {
        return values;
    }

    public String toString() {
        return "[" + DateClass.class + "]" + "\r\n";
    }
}