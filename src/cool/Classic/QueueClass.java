package cool.Classic;

import java.io.Serializable;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QueueClass<T> implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 2857213343328263628L;
    private Queue<T> values;

    public QueueClass() { 
        this(new ConcurrentLinkedQueue<T>());
    }

    public QueueClass(Queue<T> value) {
        set(value);
    }

    private void set(Queue<T> value) {
        this.values = value;
    }

    public void setQueueValues(Queue<T> value) {
        value.parallelStream().forEach(p -> {
            values.offer(p);
        });
    }

    public Queue<T> get() {
        return values;
    }

    public String toString() {
        return "[" + QueueClass.class + "]" + "\r\n";
    }
}