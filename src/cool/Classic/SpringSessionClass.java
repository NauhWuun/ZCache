package cool.Classic;

import java.io.Serializable;

import cool.External.SpringSession;

public class SpringSessionClass implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = -7087440057164976898L;

    private SpringSession hCache;

    public SpringSessionClass(SpringSession value) {
        set(value);
    }

    private void set(SpringSession value) {
        this.hCache = value;
    }

    public SpringSession get() {
        return hCache;
    }

    public String toString() {
        return "[" + SpringSessionClass.class + "]" + "\r\n";
    }
}