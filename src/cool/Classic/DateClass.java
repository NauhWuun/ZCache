package cool.Classic;

import java.util.Date;

import cool.CallFuctor;

public class DateClass implements CallFuctor 
{
    public Date call(Object obj) {
        return new Date(Long.getLong((String) obj));
    }
}