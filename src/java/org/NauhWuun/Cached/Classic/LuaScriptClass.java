package org.NauhWuun.Cached.Classic;

import java.io.Serializable;

public class LuaScriptClass<JsonObject> implements Serializable 
{
    /**
     *
     */
    private static final long serialVersionUID = 3120014360018567292L;
    private JsonObject values;

    public LuaScriptClass(JsonObject value) {
        set(value);
    }

    private void set(JsonObject value) {
        this.values = value;
    }

    public JsonObject get() {
        return values;
    }

    public String toString() {
        return "[" + LuaScriptClass.class + "]" + "\r\n";
    }
}