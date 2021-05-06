import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findDisappearedNumbers {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> ret = new ArrayList<Integer>();
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i + 1 != nums[i]){
                ret.add(i+1);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(17^18^19^20^21^22^23^25^26^29);
    }
}
