package org.NauhWuun.Cached.Classic;

import java.io.Serializable;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockClass implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 4079086972474660978L;
    private ReadWriteLock values;
    private boolean[] lockStatus = {false, false};

    public ReadWriteLockClass() { 
        this(new ReentrantReadWriteLock());
    }

    public ReadWriteLockClass(ReadWriteLock value) {
        set(value);
    }

    private void set(ReadWriteLock value) {
        this.values = value;
    }

    public void setReadLock(boolean ReadLock) {
        lockStatus[0] = ReadLock;
    }

    public void setWriteLock(boolean WriteLock) {
        lockStatus[1] = WriteLock;
    }

    public boolean isRead() {
        return lockStatus[0];
    }

    public boolean isWrite() {
        return lockStatus[1];
    }

    public ReadWriteLock get() {
        return values;
    }

    public String toString() {
        return "[" + ReadWriteLockClass.class + "]" + "\r\n";
    }
}