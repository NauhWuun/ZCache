package cool.Classic;

import cool.CallFuctor;

public class FloatClass implements CallFuctor 
{
    public Float call(Object obj) { return (Float) obj; }
}