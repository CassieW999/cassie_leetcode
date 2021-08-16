public class cutoffRange {
    // [90, 90, 80, 80, 70]   3
    //
    public int cutoffRange (int[] nums, int range){
        int[] freq = new int[101];
        for (int num : nums){
            freq[num] += 1;
        }
        int res = 0;
        for (int i = 100; i > 0; i--) {
            if (range <= 0) break;
            range -= nums[i];
            res += nums[i];
        }
        return res;
    }
}
