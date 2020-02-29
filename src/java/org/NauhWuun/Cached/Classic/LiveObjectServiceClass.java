package org.NauhWuun.Cached.Classic;

import java.io.Serializable;

public class LiveObjectServiceClass<Channel> implements Serializable 
{
    /**
     *
     */
    private static final long serialVersionUID = -6397322156447154890L;
    private Channel values;

    public LiveObjectServiceClass(Channel value) {
        set(value);
    }

    private void set(Channel value) {
        this.values = value;
    }

    public Channel get() {
        return values;
    }

    public String toString() {
        return "[" + LiveObjectServiceClass.class + "]" + "\r\n";
    }
}