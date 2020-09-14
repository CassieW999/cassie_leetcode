import java.util.HashSet;

public class ContainsDuplicateII {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return false;
        if (k <= 0 ) return false;
        if (k == 1) return true;

        HashSet<Integer> rec = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (rec.contains(nums[i])) return true;

            rec.add(nums[i]);
            if (rec.size() == k + 1){
                rec.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        boolean flag = containsNearbyDuplicate(nums,2);
        System.out.println(flag);
    }
}
