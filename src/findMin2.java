public class findMin2 {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        if (nums.length == 1) return nums[0];
        while (l <= r){
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]){
                l = m + 1;
            }else if (nums[m] < nums[r]){
                r = m;
            }else {
                r --;
            }
        }
        return nums[l];
    }
}
