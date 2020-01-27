package cool.Classic;

import java.io.Serializable;

import cool.External.BloomFilter;

public class BloomFilterClass implements Serializable 
{
    /**
     *
     */
    private static final long serialVersionUID = 5390029703683619102L;
    private BloomFilter values;
    private int min = 100, max = 1024;

    public BloomFilterClass(int min, int max) { 
        this(new BloomFilter(min, max), min, max);
    }

    public BloomFilterClass(BloomFilter value, int min, int max) {
        set(value, min, max);
    }

    private void set(BloomFilter value, int min, int max) {
        this.values = value;
        this.min = min;
        this.max = max;
    }

    public BloomFilter get() {
        return values;
    }

    public int getBloomFilterMin() {
        return this.min;
    }

    public int getBloomFilterMax() {
        return this.max;
    }

    public String toString() {
        return "[" + BloomFilterClass.class + "]" + "\r\n";
    }
}