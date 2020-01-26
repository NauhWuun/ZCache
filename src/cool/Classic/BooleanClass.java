package cool.Classic;

import cool.CallFuctor;

public class BooleanClass implements CallFuctor 
{
    public Boolean call(Object obj) {
        return Boolean.valueOf((boolean) obj == true);
    }
}