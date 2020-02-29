package org.NauhWuun.Cached.Classic;

import java.io.Serializable;
import java.util.Set;

public class MultiSetClass<T> implements Serializable 
{
    /**
     *
     */
    private static final long serialVersionUID = -1134526908326779600L;
    private Set<T> hCache;

    public MultiSetClass(Set<T> value) {
        set(value);
    }

    private void set(Set<T> value) {
        this.hCache = value;
    }

    public Set<T> get() {
        return hCache;
    }

    public String toString() {
        return "[" + MultiSetClass.class + "]" + "\r\n";
    }
}