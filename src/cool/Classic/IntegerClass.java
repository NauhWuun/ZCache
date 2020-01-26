package cool.Classic;

import cool.CallFuctor;

public class IntegerClass implements CallFuctor 
{
    public Integer call(Object obj) {
        return Integer.valueOf((String) obj);
    }
}