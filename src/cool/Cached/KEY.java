package cool.Cached;

import cool.HashAlgorithm;
import cool.RockRand;

public class KEY 
{
    long    key        = 1;
    long    createTime = 1;
    long    timeOut    = 1;
    boolean priority   = false;

    public KEY() {
        this(1000 * 60, RockRand.getUnsignedLong(), false);
    }

    public KEY(final long timeout, final long key, final boolean priority) {
        this.setCreatedTime();
        this.setPriority(priority);
        this.setKey(key);
        this.setTimeOut(timeout);
    }

    private final KEY setPriority(final boolean _priority) {
        return new KEY(10, RockRand.getUnsignedLong(), _priority);
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
        return  key > 0 && createTime > 0 && timeOut > 0; 
    }
}
