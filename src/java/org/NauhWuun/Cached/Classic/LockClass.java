package org.NauhWuun.Cached.Classic;

import java.io.Serializable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockClass implements Serializable 
{
    /**
     *
     */
    private static final long serialVersionUID = -3054427405473352922L;
    private Lock values;

    public LockClass(int counts) { 
        this(new ReentrantLock());
    }

    public LockClass(Lock value) {
        set(value);
    }

    private void set(Lock value) {
        this.values = value;
    }

    public Lock get() {
        return values;
    }

    public String toString() {
        return "[" + LockClass.class + "]" + "\r\n";
    }
}