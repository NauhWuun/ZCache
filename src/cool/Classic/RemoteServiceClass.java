package cool.Classic;

import java.io.Serializable;

public class RemoteServiceClass<Channel> implements Serializable 
{   
    /**
     *
     */
    private static final long serialVersionUID = -533887550694157773L;
    private Channel values;

    public RemoteServiceClass(Channel value) {
        set(value);
    }

    private void set(Channel value) {
        this.values = value;
    }

    public Channel get() {
        return values;
    }

    public String toString() {
        return "[" + RemoteServiceClass.class + "]" + "\r\n";
    }
}