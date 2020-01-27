package cool.Classic;

import java.io.Serializable;

public class SpringSessionClass<JsonObject> implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = -7087440057164976898L;

    private JsonObject ssCache;

    public SpringSessionClass(JsonObject value) {
        set(value);
    }

    private void set(JsonObject value) {
        this.ssCache = value;
    }

    public JsonObject get() {
        return ssCache;
    }

    public String toString() {
        return "[" + SpringSessionClass.class + "]" + "\r\n";
    }
}