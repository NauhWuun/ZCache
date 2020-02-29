package org.NauhWuun.Cached.Cached;

import org.NauhWuun.Cached.HashAlgorithm;
import org.NauhWuun.Cached.RockRand;

public class KEY
{
    private long    key        = 1;
    private long    createTime = 1;
    private long    timeOut    = 1;
    private boolean priority   = false;

    public KEY() {
        this(1000 * 10, RockRand.getUnsignedLong(), false);
    }

    public KEY(final long timeout, final long key, final boolean priority) {
        this.setCreatedTime();
        this.setPriority(priority);
        this.setKey(key);
        this.setTimeOut(timeout);
    }

    private final void setPriority(final boolean _priority) {
        this.priority = _priority;
    }

    public final boolean getPriority() {
        return priority;
    }

    private final KEY setKey(final long _key) {
        key = _key;
        return this;
    }

    public final long getKey() {
        return key;
    }

    public final long hashValue(final String value) {
        return HashAlgorithm.FNV1A_64_HASH(value);
    }

    private final KEY setTimeOut(final long _timeout) {
        timeOut = _timeout;
        return this;
    }

    public final long getTimeOut() {
        return timeOut;
    }

    private void setCreatedTime() {
        createTime = System.currentTimeMillis();
    }

    public final long getCreatedTime() {
        return createTime;
    }

    public final boolean isTimeOut() {
        return (System.currentTimeMillis() - this.getCreatedTime()) >= this.getTimeOut();
    }

    public Boolean validator() {
        return key > 0 && createTime > 0 && timeOut > 0; 
    }
}
