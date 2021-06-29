public class binarySearchTemplate {
    // search one num in a sorted list
    public int searchNum(int target, int[] nums){
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // search left bound of target
    public int leftBound(int target, int[] nums){
        int left = 0, right = nums.length;
        while (left < right){
            int mid = left + (right - left)/2;
            if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] >= target){
                right = mid;
            }
        }
        if (left == nums.length) return -1;
        return nums[left] == target ? left : -1;
    }

    // search right bound of target
    public int rightBound(int target, int[] nums){
        int left = 0, right = nums.length;
        while (left < right){
            int mid = left + (right - left)/2;
            if (nums[mid] <= target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        if (left == 0)return -1;
        return nums[left - 1] == target ? (left - 1) : -1;
    }
}