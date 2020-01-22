package cool.Cached;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

class SupportClass 
{
    static Map<String, CallFuctor> SupportList = new ConcurrentHashMap<>(40);

    SupportClass()
    {
        SupportList.put("String",            new StringClass());
        SupportList.put("Date",              new DateClass());
        SupportList.put("Boolean",           new BooleanClass());
        SupportList.put("Long",              new LongClass());
        SupportList.put("Integer",           new IntegerClass());
        SupportList.put("Double",            new DoubleClass());
        SupportList.put("Float",             new FloatClass());
        SupportList.put("List",              new ListClass());
        SupportList.put("HTTPSession",       new HTTPSessionClass());
        SupportList.put("Queue",             new QueueClass());
        SupportList.put("BlockingQueue",     new BlockingQueueClass());
        SupportList.put("BlockingDeque",     new BlockingDequeClass());
        SupportList.put("Deque",             new DequeClass());
        SupportList.put("Map",               new MapClass());
        SupportList.put("Set",               new SetClass());
        SupportList.put("BitSet",            new BitSetClass());
        SupportList.put("SetMultiMap",       new SetMultiMapClass());
        SupportList.put("ListMultiMap",      new ListMultiMapClass());
        SupportList.put("MultiSet",          new MultiSetClass());
        SupportList.put("Lock",              new LockClass());
        SupportList.put("ReadWriteLock",     new ReadWriteLockClass());
        SupportList.put("Semaphore",         new SemaphoreClass());
        SupportList.put("CountDownLatch",    new CountDownLatchClass());
        SupportList.put("Geo",               new GeoClass());
        SupportList.put("AtmicLong",         new AtmicLongClass());
        SupportList.put("SpringCache",       new SpringCacheClass());
        SupportList.put("TomcatSession",     new TomcatSessionClass());
        SupportList.put("HibernateCache",    new HibernateCacheClass());
        SupportList.put("SpringSession",     new SpringSessionClass());
        SupportList.put("BloomFilter",       new BloomFilterClass());
        SupportList.put("ScoredSortedSet",   new ScoredSortedSetClass());
        SupportList.put("SortedSet",         new SortedSetClass());
        SupportList.put("LuaScript",         new LuaScriptClass());
        SupportList.put("MapCache",          new MapCacheClass());
        SupportList.put("LiveObjectService", new LiveObjectServiceClass());
        SupportList.put("ExecutorService",   new ExecutorServiceClass());
        SupportList.put("SchedulerService",  new SchedulerServiceClass());
        SupportList.put("RemoteService",     new RemoteServiceClass());
        SupportList.put("PublishSubscribe",  new PublishSubscribeClass());
    }

    public interface CallFuctor<T> {
        T call(T obj);
    }

    class StringClass implements CallFuctor {
        public String call(Object obj) { return (String) obj; }
    }

    class DateClass implements CallFuctor {
        public Date call(Object obj) {
            return new Date(Long.getLong((String) obj));
        }
    }

    class BooleanClass implements CallFuctor {
        public Boolean call(Object obj) {
            return Boolean.valueOf((boolean) obj == true);
        }
    }

    class LongClass implements CallFuctor {
        public Long call(Object obj) { return Long.valueOf((String) obj); }
    }

    class IntegerClass implements CallFuctor {
        public Integer call(Object obj) {
            return Integer.valueOf((String) obj);
        }
    }

    class DoubleClass implements CallFuctor {
        public Double call(Object obj) {
            return (Double) obj;
        }
    }

    class FloatClass implements CallFuctor {
        public Float call(Object obj) { return (Float) obj; }
    }

    class ListClass implements CallFuctor {
        public List call(Object obj) {
            return Collections.singletonList(new LinkedList<Object>().add(obj));
        }
    }

    class HTTPSessionClass implements CallFuctor {
        public Object call(Object obj) {
            return null;
        }
    }

    class QueueClass implements CallFuctor {
        public Object call(Object obj) {
            return null;
        }
    }

    class BlockingQueueClass implements CallFuctor {
        public Object call(Object obj) {
            return null;
        }
    }

    class BlockingDequeClass implements CallFuctor {
        public Object call(Object obj) {
            return null;
        }
    }

    class DequeClass implements CallFuctor {
        public Object call(Object obj) {
            return null;
        }
    }

    class MapClass implements CallFuctor {
        public Object call(Object obj) {
            return null;
        }
    }

    class SetClass implements CallFuctor {
        public Object call(Object obj) {
            return null;
        }
    }

    class BitSetClass implements CallFuctor {
        public Object call(Object obj) {
            return null;
        }
    }

    class SetMultiMapClass implements CallFuctor {
        public Object call(Object obj) {
            return null;
        }
    }

    class ListMultiMapClass implements CallFuctor {
        public Object call(Object obj) {
            return null;
        }
    }

    class MultiSetClass implements CallFuctor {
        public Object call(Object obj) {
            return null;
        }
    }

    class LockClass implements CallFuctor {
        public Object call(Object obj) {
            return null;
        }
    }

    class ReadWriteLockClass implements CallFuctor {
        public Object call(Object obj) {
            return null;
        }
    }

    class SemaphoreClass implements CallFuctor {
        public Object call(Object obj) {
            return null;
        }
    }

    class CountDownLatchClass implements CallFuctor {
        public Object call(Object obj) {
            return null;
        }
    }

    class GeoClass implements CallFuctor {
        public Object call(Object obj) {
            return null;
        }
    }

    class AtmicLongClass implements CallFuctor {
        public Object call(Object obj) {
            return null;
        }
    }

    class SpringCacheClass implements CallFuctor {
        public Object call(Object obj) {
            return null;
        }
    }

    class TomcatSessionClass implements CallFuctor {
        public Object call(Object obj) {
            return null;
        }
    }

    class HibernateCacheClass implements CallFuctor {
        public Object call(Object obj) {
            return null;
        }
    }

    class SpringSessionClass implements CallFuctor {
        public Object call(Object obj) {
            return null;
        }
    }

    class BloomFilterClass implements CallFuctor {
        public Object call(Object obj) {
            return null;
        }
    }

    class ScoredSortedSetClass implements CallFuctor {
        public Object call(Object obj) {
            return null;
        }
    }

    class SortedSetClass implements CallFuctor {
        public Object call(Object obj) {
            return null;
        }
    }

    class LuaScriptClass implements CallFuctor {
        public Object call(Object obj) {
            return null;
        }
    }

    class MapCacheClass implements CallFuctor {
        public Object call(Object obj) {
            return null;
        }
    }

    class LiveObjectServiceClass implements CallFuctor {
        public Object call(Object obj) {
            return null;
        }
    }

    class ExecutorServiceClass implements CallFuctor {
        public Object call(Object obj) {
            return null;
        }
    }

    class SchedulerServiceClass implements CallFuctor {
        public Object call(Object obj) {
            return null;
        }
    }

    class RemoteServiceClass implements CallFuctor {
        public Object call(Object obj) {
            return null;
        }
    }

    class PublishSubscribeClass implements CallFuctor {
        public Object call(Object obj) {
            return null;
        }
    }
}
