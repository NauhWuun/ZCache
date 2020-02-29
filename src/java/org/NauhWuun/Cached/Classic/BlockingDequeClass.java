package org.NauhWuun.Cached.Classic;

import java.io.Serializable;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockingDequeClass<T> implements Serializable 
{
    /**
     *
     */
    private static final long serialVersionUID = -4693456574008334403L;
    private BlockingDeque<T> values;

    public BlockingDequeClass() {
        this(new LinkedBlockingDeque<T>());
    }

    public BlockingDequeClass(BlockingDeque<T> value) {
        set(value);
    }

    private void set(BlockingDeque<T> value) {
        this.values = value;
    }

    public BlockingDeque<T> get() {
        return values;
    }

    public String toString() {
        return "[" + BlockingDequeClass.class + "]" + "\r\n";
    }
}