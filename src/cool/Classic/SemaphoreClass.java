package cool.Classic;

import java.io.Serializable;
import java.util.concurrent.Semaphore;

public class SemaphoreClass implements Serializable 
{
    /**
     *
     */
    private static final long serialVersionUID = -6707385202332242342L;
    private Semaphore values;
    private boolean lockStatus = false;
    private int count;

    public SemaphoreClass(int count) { 
        this(new Semaphore(count), count);
    }

    public SemaphoreClass(Semaphore value, int counts) {
        set(value, counts);
    }

    private void set(Semaphore value, int counts) {
        this.values = value;
        this.count = counts;
    }

    public void setLock(boolean status) {
        this.lockStatus = status;
    }

    public Semaphore get() {
        return values;
    }

    public int getSemaphoreCount() {
        return count;
    }

    public boolean getLockStatus() {
        return this.lockStatus;
    }

    public String toString() {
        return "[" + SemaphoreClass.class + "]" + "\r\n";
    }
}