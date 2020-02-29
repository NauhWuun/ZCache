package org.NauhWuun.Cached.Classic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListClass<T> implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 918227119451148485L;
    private List<T> values;

    public ListClass() { 
        this(new ArrayList<T>());
    }

    public ListClass(List<T> value) {
        set(value);
    }

    private void set(List<T> value) {
        this.values = value;
    }

    public List<T> get() {
        return values;
    }

    public String toString() {
        return "[" + ListClass.class + "]" + "\r\n";
    }
}