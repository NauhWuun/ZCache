package cool;

import java.util.concurrent.atomic.AtomicMarkableReference;

public class LockFree<T> 
{
    AtomicMarkableReference<LockFree<T>> lock;
    T value;

    public LockFree(T value, LockFree<T> lockVal) {
        this.lock  = new AtomicMarkableReference<LockFree<T>>(lockVal, false);
        this.value = value;
    }

    public T getReference() {
        return (T) this.lock.getReference();
    }

    public void compareAndSet(LockFree<T> value) {
        this.lock.compareAndSet(value, value, false, false);
    }
}