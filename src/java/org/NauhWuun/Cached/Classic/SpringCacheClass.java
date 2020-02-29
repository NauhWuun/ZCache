package org.NauhWuun.Cached.Classic;

import java.io.Serializable;

public class SpringCacheClass<JsonObject> implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = -5929040102284133738L;

    private JsonObject sCache;

    public SpringCacheClass(JsonObject value) {
        set(value);
    }

    private void set(JsonObject value) {
        this.sCache = value;
    }

    public JsonObject get() {
        return sCache;
    }

    public String toString() {
        return "[" + SpringCacheClass.class + "]" + "\r\n";
    }
}