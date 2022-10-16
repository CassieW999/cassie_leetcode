import java.util.Arrays;

public class canPartitionKSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        int target = sum / k;
//        Arrays.sort(nums, Collections.reverseOrder());
        int[] buckets = new int[k];
        return dfs(nums, target, 0, buckets);
    }

    public boolean dfs(int[] nums, int target, int idx, int[] buckets){
        if (idx == nums.length){
            return true;
        }

        for (int i = 0; i < buckets.length; i++){
            if (buckets[i] + nums[idx] > target) continue;
            buckets[i] += nums[idx];
            if (dfs(nums, target, idx + 1, buckets)) return true;
            buckets[i] -= nums[idx];
        }
        return false;
    }
}
