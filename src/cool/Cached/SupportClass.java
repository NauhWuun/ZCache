package cool.Cached;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import cool.CallFuctor;
import cool.Classic.AtomicLongClass;
import cool.Classic.BitSetClass;
import cool.Classic.BlockingDequeClass;
import cool.Classic.BlockingQueueClass;
import cool.Classic.BloomFilterClass;
import cool.Classic.BooleanClass;
import cool.Classic.CountDownLatchClass;
import cool.Classic.DateClass;
import cool.Classic.DequeClass;
import cool.Classic.DoubleClass;
import cool.Classic.ExecutorServiceClass;
import cool.Classic.FloatClass;
import cool.Classic.GeoClass;
import cool.Classic.HTTPSessionClass;
import cool.Classic.HibernateCacheClass;
import cool.Classic.IntegerClass;
import cool.Classic.ListClass;
import cool.Classic.ListMultiMapClass;
import cool.Classic.LiveObjectServiceClass;
import cool.Classic.LockClass;
import cool.Classic.LongClass;
import cool.Classic.LuaScriptClass;
import cool.Classic.MapCacheClass;
import cool.Classic.MapClass;
import cool.Classic.MultiSetClass;
import cool.Classic.PublishSubscribeClass;
import cool.Classic.QueueClass;
import cool.Classic.ReadWriteLockClass;
import cool.Classic.RemoteServiceClass;
import cool.Classic.SchedulerServiceClass;
import cool.Classic.SemaphoreClass;
import cool.Classic.SetClass;
import cool.Classic.SetMultiMapClass;
import cool.Classic.SortedSetClass;
import cool.Classic.SpringCacheClass;
import cool.Classic.SpringSessionClass;
import cool.Classic.StringClass;
import cool.Classic.TomcatSessionClass;

public class SupportClass 
{
    public static Map<String, Object> SupportList = new ConcurrentHashMap<>(40);

    static
    {
        SupportList.put("String",            StringClass.class);
        SupportList.put("Date",              DateClass.class);
        SupportList.put("Boolean",           BooleanClass.class);
        SupportList.put("Long",              LongClass.class);
        SupportList.put("Integer",           IntegerClass.class);
        SupportList.put("Double",            DoubleClass.class);
        SupportList.put("Float",             FloatClass.class);
        SupportList.put("List",              ListClass.class);
        SupportList.put("HTTPSession",       HTTPSessionClass.class);
        SupportList.put("Queue",             QueueClass.class);
        SupportList.put("BlockingQueue",     BlockingQueueClass.class);
        SupportList.put("BlockingDeque",     BlockingDequeClass.class);
        SupportList.put("Deque",             DequeClass.class);
        SupportList.put("Map",               MapClass.class);
        SupportList.put("Set",               SetClass.class);
        SupportList.put("BitSet",            BitSetClass.class);
        SupportList.put("SetMultiMap",       SetMultiMapClass.class);
        SupportList.put("ListMultiMap",      ListMultiMapClass.class);
        SupportList.put("MultiSet",          MultiSetClass.class);
        SupportList.put("Lock",              LockClass.class);
        SupportList.put("ReadWriteLock",     ReadWriteLockClass.class);
        SupportList.put("Semaphore",         SemaphoreClass.class);
        SupportList.put("CountDownLatch",    CountDownLatchClass.class);
        SupportList.put("Geo",               GeoClass.class);
        SupportList.put("AtmicLong",         AtomicLongClass.class);
        SupportList.put("SpringCache",       SpringCacheClass.class);
        SupportList.put("TomcatSession",     TomcatSessionClass.class);
        SupportList.put("HibernateCache",    HibernateCacheClass.class);
        SupportList.put("SpringSession",     SpringSessionClass.class);
        SupportList.put("BloomFilter",       BloomFilterClass.class);
        SupportList.put("SortedSet",         SortedSetClass.class);
        SupportList.put("LuaScript",         LuaScriptClass.class);
        SupportList.put("MapCache",          MapCacheClass.class);
        SupportList.put("LiveObjectService", LiveObjectServiceClass.class);
        SupportList.put("ExecutorService",   ExecutorServiceClass.class);
        SupportList.put("SchedulerService",  SchedulerServiceClass.class);
        SupportList.put("RemoteService",     RemoteServiceClass.class);
        SupportList.put("PublishSubscribe",  PublishSubscribeClass.class);
    }

    public Object getSupportClass(String ClassName) {
        return SupportList.get(ClassName);
    }
}
