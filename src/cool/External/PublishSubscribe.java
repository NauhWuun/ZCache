package cool.External;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class PublishSubscribe<E> 
{
    private String topicName;
    private E messageObject;
    private long publishTime, PubID, SubID;

    public PublishSubscribe(long PubID, long SubID, String topicName, E messageObject, long publishTime) {
        this.topicName = topicName;
        this.publishTime = publishTime;
        this.PubID = PubID;
        this.SubID = SubID;

        if (messageObject instanceof String     || 
            messageObject instanceof Integer    || 
            messageObject instanceof Long       || 
            messageObject instanceof byte[]     || 
            messageObject instanceof Object     )
            this.messageObject = messageObject;
    }

    public String getTopicName() {
        return this.topicName;
    }

    public E getMessageObject() {
        return this.messageObject;
    }

    public long getPublishTime() {
        return this.publishTime;
    }

    public String getHost() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            return "127.0.0.1";
        }
    }

    public long getPubID() {
        return this.PubID;
    }

    public long getSubID() {
        return this.SubID;
    }
}