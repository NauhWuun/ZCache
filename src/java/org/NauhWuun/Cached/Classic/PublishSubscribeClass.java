package org.NauhWuun.Cached.Classic;

import java.io.Serializable;

import cool.External.PublishSubscribe;

public class PublishSubscribeClass<E> implements Serializable 
{
    /**
	 *
	 */
	private static final long serialVersionUID = 2488720711223944843L;
	private PublishSubscribe<E> values;

    public PublishSubscribeClass(PublishSubscribe<E> value) {
        set(value);
    }

    private void set(PublishSubscribe<E> value) {
        this.values = value;
    }

    public PublishSubscribe<E> get() {
        return values;
    }

    public String toString() {
        return "[" + PublishSubscribeClass.class + "]" + "\r\n";
    }
}