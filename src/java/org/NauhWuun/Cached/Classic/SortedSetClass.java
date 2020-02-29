package org.NauhWuun.Cached.Classic;

import java.io.Serializable;
import java.util.Collections;
import java.util.SortedSet;

public class SortedSetClass<T> implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = -88092241553747513L;
    private SortedSet<T> values;

    public SortedSetClass() { 
        this(Collections.emptySortedSet());
    }

    public SortedSetClass(SortedSet<T> value) {
        set(value);
    }

    private void set(SortedSet<T> value) {
        this.values = value;
    }

    public SortedSet<T> get() {
        return values;
    }

    public String toString() {
        return "[" + SortedSetClass.class + "]" + "\r\n";
    }
}