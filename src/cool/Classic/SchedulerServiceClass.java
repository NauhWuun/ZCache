package cool.Classic;

import java.io.Serializable;

import cool.External.SchedulerService;

public class SchedulerServiceClass implements Serializable 
{
    /**
     *
     */
    private static final long serialVersionUID = 8027863238146868109L;
    private SchedulerService hCache;

    public SchedulerServiceClass(SchedulerService value) {
        set(value);
    }

    private void set(SchedulerService value) {
        this.hCache = value;
    }

    public SchedulerService get() {
        return hCache;
    }

    public String toString() {
        return "[" + SchedulerServiceClass.class + "]" + "\r\n";
    }
}