package cool.Classic;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Deque;

public class DequeClass<T> implements Serializable 
{
    /**
     *
     */
    private static final long serialVersionUID = 2936662894236712265L;
    private Deque<T> values;

    public DequeClass() { 
        this(new ArrayDeque<T>());
    }

    public DequeClass(Deque<T> value) {
        set(value);
    }

    private void set(Deque<T> value) {
        this.values = value;
    }

    public Deque<T> get() {
        return values;
    }

    public String toString() {
        return "[" + DequeClass.class + "]" + "\r\n";
    }
}