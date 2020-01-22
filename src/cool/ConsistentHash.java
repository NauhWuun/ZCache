package cool;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHash 
{
    private String[] keys;
    private int virtualNodeCount;

    private TreeMap<Integer,String> hashCircle = new TreeMap<>();

    public ConsistentHash(String[] keys) {
        this(keys, 999999999 + 1);
    }

    public ConsistentHash(String[] keys , int virtualNodeCount) {
        this.keys = keys;

        if (virtualNodeCount < 1 || virtualNodeCount > 999999999) {
            throw new IllegalArgumentException("must bettween 1 - 999999999");
        }

        this.virtualNodeCount = virtualNodeCount;
        for (String key : keys) {
            addKey(key);
        }
    }

    public void addKey(String key) {
        List<String> virtualKeys = this.genVirtualNodeKeys(key);

        for(String tmp : virtualKeys) {
            int keyHashCode = _hash(tmp);
            hashCircle.put(keyHashCode, tmp);
        }
    }

    public void removeKey(String key) {
        List<String> virtualKeys = this.genVirtualNodeKeys(key);

        for(String tmp : virtualKeys) {
            int keyHashCode = _hash(tmp);
            hashCircle.remove(keyHashCode);
        }
    }

    public String hash(String str) {
        int argHash = _hash(str);
        SortedMap<Integer,String> subTreeMap = hashCircle.tailMap((int)argHash);

        int tmpKey = subTreeMap.isEmpty() ? hashCircle.firstKey() : subTreeMap.firstKey();
        return getRealKey(hashCircle.get(tmpKey));
    }

    private int _hash(String key) {
        return (int)HashAlgorithm.FNV1A_64_HASH(key);
    }

    private List<String> genVirtualNodeKeys(String key){
        List<String> keys = new ArrayList<>(virtualNodeCount);

        for(int i = 0 ; i < virtualNodeCount ; i++) {
            StringBuilder sb = new StringBuilder(key);
            sb.append("$V").append(String.format("%03d",i));
            keys.add(sb.toString());
        }

        return keys;
    }

    private String getRealKey(String virtualNodeKey) {
        return virtualNodeKey.substring(0, virtualNodeKey.length() - 5);
    }
}

/**
 * @Test
 *     public void test() {
 *         ConsistentHash consistentHash = new ConsistentHash(new String[] {"127.0.0.1", "127.0.0.2", "127.0.0.3", "127.0.0.4"});
 *
 *         Map<String, Integer> countMap = new HashMap<>();
 *
 *         for(int i = 0 ; i < 100000 ; i++) {
 *             String tmp = UUID.randomUUID().toString();
 *             String key = consistentHash.hash(tmp);
 *
 *             if (countMap.containsKey(key))
 *                 countMap.put(key, countMap.get(key) + 1);
 *             else
 *                 countMap.put(key, 1);
 *         }
 *     }
 */
