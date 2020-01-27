package cool.Classic;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TomcatSessionClass implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 4772758589209976302L;
    protected Map<String, Object> attributes = new ConcurrentHashMap<String, Object>();

    public TomcatSessionClass() { 
        this("", new Object());
    }

    public TomcatSessionClass(String key, Object value) {
        set(key, value);
    }

    private void set(String key, Object value) {
        attributes.put(key, value);
    }

    public Object get(String key) {
        return attributes.get(key);
    }

    public String toString() {
        return "[" + TomcatSessionClass.class + "]" + "\r\n";
    }
}