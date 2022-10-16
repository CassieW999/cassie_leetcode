import java.util.*;

public class AllOne {
    Map<String, Integer> freq;
    TreeMap<Integer, Set<String>> lis;

    public AllOne() {
        freq = new HashMap<>();
        lis = new TreeMap<>();
    }

    public void inc(String key) {
        freq.put(key, freq.getOrDefault(key, 0) + 1);
        int cur = freq.get(key);
        Set<String> curList = lis.getOrDefault(cur, new HashSet<>());
        curList.add(key);
        lis.put(cur, curList);
    }

    public void dec(String key) {
        freq.put(key, freq.getOrDefault(key, 0) - 1);
        Set<String> curSet = lis.get(freq.get(key) + 1);
        if (freq.get(key) <= 0){
            freq.remove(key);
            if (curSet != null && curSet.contains(key)) curSet.remove(key);
        }else{
            if (curSet != null && curSet.contains(key)) curSet.remove(key);
        }
        lis.put(freq.get(key) + 1, curSet);
        Set<String> newList = lis.getOrDefault(freq.get(key), new HashSet<>());
        newList.add(key);
        lis.put(freq.get(key), newList);
    }

    public String getMaxKey() {
        int max = lis.lastKey();
        return lis.get(max).iterator().next();
    }

    public String getMinKey() {
        int min = lis.firstKey();
        return lis.get(min).iterator().next();
    }
}
