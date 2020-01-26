package cool.Classic;

import java.util.Collections;
import java.util.LinkedList;

import cool.CallFuctor;

public class ListClass implements CallFuctor
{
    public <T> T call(T obj) {
        return (T) Collections.singletonList(new LinkedList<Object>().add(obj));
    }
}