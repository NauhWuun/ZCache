package cool.External;

import java.util.List;
import com.google.common.collect.*;

public class ListMultiMap<K, V>
{
    ListMultimap<K, V> map = ArrayListMultimap.create();
    List<V> list;

    public void Push(K key, V value) {
        map.put(key, value);
    }

    public List<K> getList(K key) {
        list = map.get(value);

        for (V value : list) {
            list.add(value);
        }
        return map.get(value);
    }

    public boolean getKey(K key) {
        return map.containsKey(key);
    }

    public V getValue(K key) {
        return map.get(key);
    }

    public void remove(K key, V value) {
        map.remove(key, value);
    }
}