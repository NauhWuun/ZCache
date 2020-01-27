package cool.Classic;

import java.io.Serializable;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchClass implements Serializable 
{
    /**
     *
     */
    private static final long serialVersionUID = -1883961100750099639L;
    private CountDownLatch values;
    private int cdlCounts;

    public CountDownLatchClass(int counts) { 
        this(new CountDownLatch(counts), counts);
    }

    public CountDownLatchClass(CountDownLatch value, int counts) {
        set(value, counts);
    }

    private void set(CountDownLatch value, int counts) {
        this.values = value;
        this.cdlCounts = counts;
    }

    public CountDownLatch get() {
        return values;
    }

    public int getCountDownLatchCounts() {
        return this.cdlCounts;
    }

    public String toString() {
        return "[" + CountDownLatchClass.class + "]" + "\r\n";
    }
}