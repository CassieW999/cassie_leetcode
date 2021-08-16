import java.util.HashMap;
import java.util.Map;

public class fourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                map1.put(nums1[i] + nums2[j], map1.getOrDefault(nums1[i] + nums2[j], 0) + 1);
                map2.put(nums3[i] + nums4[j], map2.getOrDefault(nums3[i] + nums4[j], 0) + 1);
            }
        }
        int res = 0;
        for (Map.Entry entry : map1.entrySet()){
            int freq1 = (int)entry.getValue();
            int freq2 = map2.getOrDefault(0 - (int)entry.getKey(),0);
            res += freq1 * freq2;
        }
        return res;
    }
}
