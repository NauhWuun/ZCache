package cool.Classic;

import java.io.Serializable;

public class HTTPSessionClass<JsonObject> implements Serializable 
{
    /**
     *
     */
    private static final long serialVersionUID = 3322846951939122786L;
    private JsonObject values;

    public HTTPSessionClass(JsonObject value) {
        set(value);
    }

    private void set(JsonObject value) {
        this.values = value;
    }

    public JsonObject get() {
        return values;
    }

    public String toString() {
        return "[" + HTTPSessionClass.class + "]" + "\r\n";
    }
}