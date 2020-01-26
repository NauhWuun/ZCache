package cool.Classic;

import cool.CallFuctor;

public class DoubleClass implements CallFuctor 
{
    public Double call(Object obj) {
        return (Double) obj;
    }
}