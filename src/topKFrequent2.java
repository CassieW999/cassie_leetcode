import java.util.*;

public class topKFrequent2 {
    public int[] topKFrequent(int[] nums, int k) {
//        Input: nums = [1,1,1,2,2,3], k = 2
//        Output: [1,2]
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            int num = entry.getKey(), freq = entry.getValue();
            if (queue.size() == k){
                if (queue.peek()[1] < freq){
                    queue.poll();
                    queue.offer(new int[]{num, freq});
                }
            }else{
                queue.offer(new int[]{num, freq});
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll()[0];
        }
        return ans;
    }
}
