package org.NauhWuun.Cached.Classic;

import java.io.Serializable;
import java.util.BitSet;

public class BitSetClass implements Serializable 
{
    /**
     *
     */
    private static final long serialVersionUID = -6631007075443341170L;
    private BitSet values;

    public BitSetClass() { 
        this(new BitSet());
    }

    public BitSetClass(BitSet value) {
        set(value);
    }

    private void set(BitSet value) {
        this.values = value;
    }

    public BitSet get() {
        return values;
    }

    public String toString() {
        return "[" + BitSetClass.class + "]" + "\r\n";
    }
}