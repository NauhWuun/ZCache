package cool.Classic;

import java.io.Serializable;

import cool.External.PublishSubscribe;

public class PublishSubscribeClass<T> implements Serializable 
{
    /**
	 *
	 */
	private static final long serialVersionUID = 2488720711223944843L;
	private PublishSubscribe<T> hCache;

    public PublishSubscribeClass(PublishSubscribe<T> value) {
        set(value);
    }

    private void set(PublishSubscribe<T> value) {
        this.hCache = value;
    }

    public PublishSubscribe<T> get() {
        return hCache;
    }

    public String toString() {
        return "[" + PublishSubscribeClass.class + "]" + "\r\n";
    }
}