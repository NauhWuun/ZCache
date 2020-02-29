package org.NauhWuun.Cached.Classic;

import java.io.Serializable;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueClass<T> implements Serializable 
{
    /**
     *
     */
    private static final long serialVersionUID = -825369387878136181L;
    private BlockingQueue<T> values;

    public BlockingQueueClass() { 
        this(new LinkedBlockingQueue<T>());
    }

    public BlockingQueueClass(BlockingQueue<T> value) {
        set(value);
    }

    private void set(BlockingQueue<T> value) {
        this.values = value;
    }

    public BlockingQueue<T> get() {
        return values;
    }

    public String toString() {
        return "[" + BlockingQueueClass.class + "]" + "\r\n";
    }
}