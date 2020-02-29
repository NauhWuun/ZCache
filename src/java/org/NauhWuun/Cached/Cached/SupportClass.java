package org.NauhWuun.Cached.Cached;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import cool.Classic.AtomicLongClass;
import org.NauhWuun.Cached.Classic.BitSetClass;
import org.NauhWuun.Cached.Classic.BlockingDequeClass;
import org.NauhWuun.Cached.Classic.BlockingQueueClass;
import org.NauhWuun.Cached.Classic.BloomFilterClass;
import org.NauhWuun.Cached.Classic.BooleanClass;
import org.NauhWuun.Cached.Classic.CountDownLatchClass;
import org.NauhWuun.Cached.Classic.DateClass;
import org.NauhWuun.Cached.Classic.DequeClass;
import org.NauhWuun.Cached.Classic.DoubleClass;
import org.NauhWuun.Cached.Classic.ExecutorServiceClass;
import org.NauhWuun.Cached.Classic.FloatClass;
import org.NauhWuun.Cached.Classic.GeoClass;
import org.NauhWuun.Cached.Classic.HTTPSessionClass;
import org.NauhWuun.Cached.Classic.HibernateCacheClass;
import org.NauhWuun.Cached.Classic.IntegerClass;
import org.NauhWuun.Cached.Classic.ListClass;
import org.NauhWuun.Cached.Classic.ListMultiMapClass;
import org.NauhWuun.Cached.Classic.LiveObjectServiceClass;
import org.NauhWuun.Cached.Classic.LockClass;
import org.NauhWuun.Cached.Classic.LongClass;
import org.NauhWuun.Cached.Classic.LuaScriptClass;
import org.NauhWuun.Cached.Classic.MapCacheClass;
import org.NauhWuun.Cached.Classic.MapClass;
import org.NauhWuun.Cached.Classic.MultiSetClass;
import org.NauhWuun.Cached.Classic.PublishSubscribeClass;
import org.NauhWuun.Cached.Classic.QueueClass;
import org.NauhWuun.Cached.Classic.ReadWriteLockClass;
import org.NauhWuun.Cached.Classic.RemoteServiceClass;
import org.NauhWuun.Cached.Classic.SchedulerServiceClass;
import org.NauhWuun.Cached.Classic.SemaphoreClass;
import org.NauhWuun.Cached.Classic.SetClass;
import org.NauhWuun.Cached.Classic.SetMultiMapClass;
import org.NauhWuun.Cached.Classic.SortedSetClass;
import org.NauhWuun.Cached.Classic.SpringCacheClass;
import org.NauhWuun.Cached.Classic.SpringSessionClass;
import org.NauhWuun.Cached.Classic.StringClass;
import org.NauhWuun.Cached.Classic.TomcatSessionClass;

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
