package org.NauhWuun.Cached.Classic;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class SetClass<T> implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 2328769296527480863L;
    private Set<T> values;

    public SetClass() { 
        this(new HashSet<T>());
    }

    public SetClass(Set<T> value) {
        set(value);
    }

    private void set(Set<T> value) {
        this.values = value;
    }

    public Set<T> get() {
        return values;
    }

    public String toString() {
        return "[" + SetClass.class + "]" + "\r\n";
    }
}