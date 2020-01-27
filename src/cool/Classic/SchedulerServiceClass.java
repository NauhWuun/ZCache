package cool.Classic;

import java.io.Serializable;

public class SchedulerServiceClass<JsonObject> implements Serializable 
{
    /**
     *
     */
    private static final long serialVersionUID = 8027863238146868109L;
    private JsonObject values;

    public SchedulerServiceClass(JsonObject value) {
        set(value);
    }

    private void set(JsonObject value) {
        this.values = value;
    }

    public JsonObject get() {
        return values;
    }

    public String toString() {
        return "[" + SchedulerServiceClass.class + "]" + "\r\n";
    }
}