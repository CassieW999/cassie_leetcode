import java.util.Arrays;
import java.util.HashMap;

public class JumpGame {
    public static boolean canJump(int[] nums) {
        if (nums.length == 0) return false;
        if (nums.length == 1) return true;
        HashMap<Integer, int[] > map = new HashMap<Integer, int[]>();
        for (int i = 0; i < nums.length; i++){
            if (nums[i] + i == nums.length - 1){
                int[] sub = Arrays.copyOfRange(nums, 0, i+1);
                map.put(i, sub);
            }
        }
        for (int j = 0; j < map.size(); j++){
            if (canJump(map.get(j))) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        canJump(nums);
        System.out.println(canJump(nums));
    }
}
