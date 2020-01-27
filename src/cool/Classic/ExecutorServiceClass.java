package cool.Classic;

import java.io.Serializable;

import cool.Pair;

public class ExecutorServiceClass implements Serializable 
{
    /**
     *
     */
    private static final long serialVersionUID = -6797903479850829797L;
    private ValueState ThreadStatus;

    public ExecutorServiceClass() { 
        ThreadStatus = new ValueState();
    }

    public ExecutorServiceClass(ValueState ThreadStatus) {
        set(ThreadStatus);
    }

    private void set(ValueState ThreadStatus) {
        this.ThreadStatus = ThreadStatus;
    }

    public ValueState get() {
        return this.ThreadStatus;
    }

    public String toString() {
        return "[" + ExecutorServiceClass.class + "]" + "\r\n";
    }

    public class ValueState
    {
        private int ThreadCount;
        private boolean running = false;
        private String ThreadName = "";
        private Runnable able;

        public ValueState() {
            this(1);
        }

        public ValueState(int ThreadPoolCounts) { 
            this.ThreadCount = ThreadPoolCounts;
        }

        public void setThreadStart(boolean isRunning) {
            this.running = isRunning;
        }

        public void setThreadEnd(boolean isRunning) {
            this.running = isRunning;
        }

        public void setThreadName(String ThreadName) {
            this.ThreadName = ThreadName;
        }

        public void setInvoke(Runnable able) {
            this.able = able;
        }

        public int getThreadCount() {
            return this.ThreadCount;
        }

        public boolean getThreadStatus() {
            return this.running;
        }

        public String getThreadName() {
            return this.ThreadName;
        }

        public Runnable getAble() {
            return this.able;
        }

        public <T> void ThreadSnapshot(Context<Pair<T>> snapshot) {}
    }

    class Context<T> {}
}