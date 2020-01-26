package cool.Classic;

import cool.CallFuctor;

public class TomcatSessionClass implements CallFuctor 
{
    private String values;

    public StringClass() { 
        this("");
    }

    public StringClass(String value) {
        set(value);
    }

    public <T> T call(T obj) {
        return obj;
    }

    private void set(String value) {
        this.values = value;
    }

    public String get() {
        return values;
    }

    public String toString() {
        return "[" + StringClass.class + "]" + "\t" +
            get() + "\r\n";
    }
}