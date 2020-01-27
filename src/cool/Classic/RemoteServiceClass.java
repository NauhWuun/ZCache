package cool.Classic;

import java.io.Serializable;

import cool.External.RemoteService;

public class RemoteServiceClass implements Serializable 
{   
    /**
     *
     */
    private static final long serialVersionUID = -533887550694157773L;
    private RemoteService hCache;

    public RemoteServiceClass(RemoteService value) {
        set(value);
    }

    private void set(RemoteService value) {
        this.hCache = value;
    }

    public RemoteService get() {
        return hCache;
    }

    public String toString() {
        return "[" + RemoteServiceClass.class + "]" + "\r\n";
    }
}