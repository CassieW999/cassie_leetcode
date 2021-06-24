import java.util.Arrays;

public class singleNumber2 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; 3 * i < nums.length; i++) {
            if (nums[3*i] != nums[3*i + 2]){
                return nums[3*i];
            }
        }
        return -1;
    }
}
