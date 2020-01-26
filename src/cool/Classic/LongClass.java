package cool.Classic;

import cool.CallFuctor;

public class LongClass implements CallFuctor 
{
    public Long call(Object obj) { 
        return Long.valueOf((String) obj); 
    }
}