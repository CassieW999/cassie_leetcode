import java.util.HashMap;
import java.util.Map;

public class numPairsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        int res = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int t : time){
            int cur = t % 60;
            freq.put(cur, freq.getOrDefault(cur, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            if (freq.containsKey(60 - key)){
                res += val * freq.get(60 - key);
            }
        }
        return res / 2 + (freq.get(0) * (freq.get(0) + 1)) / 2;
    }
}
