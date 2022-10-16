import java.util.HashMap;
import java.util.Map;

public class gg2 {
    /**
     * 1. hashmap: store number and frequency
     * 2. for (int i = min * 2 --> max * 2)
     * 3. two sum || do not count duplicate pairs
     */
    public static int gg2(int[] arr){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : arr){
            map.put(x, map.getOrDefault(x, 0) + 1);
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        int maxCount = 0;
        for (int i = min * 2; i <= max * 2; i++){
            int count = 0;
            for (int key : map.keySet()){
                if (key <= i/2 && map.containsKey(i - key)){
                    int pairCount = Math.min(map.get(key), map.get(i - key));
                    count += key == i/2 ? pairCount/2 : pairCount;
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2};
        System.out.println(gg2(arr));
    }
}
