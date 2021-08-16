public class heapSort {
    public void heapSort(int[] nums){
        buildMaxHeap(nums);
        for (int i = nums.length - 1; i > 0; i--){
            swap(nums, i, 0);
            maxHeapfy(nums, 0, i);
        }
    }
    public void buildMaxHeap(int[] nums){
        for (int i = nums.length / 2 - 1; i >= 0; i--){
            maxHeapfy(nums, i, nums.length);
        }
    }

    private void maxHeapfy(int[] nums, int i, int length) {
        int left = 2 * i + 1;
        int right = left + 1;
        int largest = i;
        if (left < length && nums[left] > nums[largest]) largest = left;
        if (right < length && nums[right] > nums[largest]) largest = right;
        if (largest != i){
            swap(nums, i, largest);
            maxHeapfy(nums, largest, length);
        }
    }

    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = right;
        nums[right] = temp;
    }
}
