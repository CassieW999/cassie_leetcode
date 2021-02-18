public class search {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int mid = l + (r-l)/2;
            if (nums[mid] == target) return true;
            if (nums[mid] == nums[l]){
                l++;
            }else if (nums[mid] > nums[l]){
                if (nums[mid] > target && nums[l] <= target){
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }else {
                if (nums[mid] < target && target <= nums[r]){
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }
}
