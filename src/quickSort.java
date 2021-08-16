public class quickSort {
    public void quickSort(int[] nums){
        quickSort(nums, 0, nums.length);
    }

    public void quickSort(int[] nums, int start, int end){ // []
        if (start >= end) return;
        int mid = partition(nums, start, end);
        quickSort(nums, mid + 1, end);
        quickSort(nums, start, mid - 1);
    }

    private int partition(int[] nums, int start, int end) {
        int key = nums[start];
        int left = start + 1;
        int right = end;
        while (left < right){
            while (left < right && nums[left] <= key) left++;
            while (left < right && nums[right] >= key) right--;
            if (left < right){
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        if (left == right && nums[right] >= key) right--;
        if (right != start) swap(nums, right, start);
        return right;
    }

    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = right;
        nums[right] = temp;
    }
}
