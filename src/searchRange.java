public class searchRange {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return new int[]{-1,-1};
        int firstTarget = findFirstTarget(nums, target);
        if (firstTarget == -1)return new int[]{-1,-1};
        int lastTarget = findLastTarget(nums, target);
        if (firstTarget == len || nums[firstTarget] != target){
            return new int[]{-1,-1};
        }
        return new int[]{firstTarget, lastTarget};
    }

    private int findFirstTarget(int[] nums, int target){
        int left = 0;
        int right = nums.length;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    private int findLastTarget(int[] nums, int target){
        int left = 0;
        int right = nums.length;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > target){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left-1;
    }
}
