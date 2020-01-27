package cool.Classic;

import java.io.Serializable;

import cool.External.SpringCache;

public class SpringCacheClass implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = -5929040102284133738L;

    private SpringCache hCache;

    public SpringCacheClass(SpringCache value) {
        set(value);
    }

    private void set(SpringCache value) {
        this.hCache = value;
    }

    public SpringCache get() {
        return hCache;
    }

    public String toString() {
        return "[" + SpringCacheClass.class + "]" + "\r\n";
    }
}