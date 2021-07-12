import java.util.Arrays;

public class minimalHeaviestSetA {
    public static int[] minimalHeaviestSetA(int[] nums){
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        int len = 1;
        while (len <= nums.length){
            int total = 0;
            for (int i = nums.length-1; i >= nums.length - len; i--) {
                total += nums[i];
            }
            if (total > sum/2){
                return getSubset(nums, nums.length - len, nums.length-1);
            }
            len++;
        }
        return new int[]{};
    }

    private static int[] getSubset(int[] nums, int start, int end) {
        int[] res = new int[end - start + 1];
        for (int i = 0; i <= end - start; i++) {
            res[i] = nums[start + i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2,4,5};
        int[] res = minimalHeaviestSetA(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + ",");
        }
    }
}
