import java.util.Set;
import java.util.TreeSet;

public class containsNearbyAlmostDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        TreeSet<Long> rec = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (rec.ceiling((long) nums[i] - (long)t) != null && rec.ceiling((long) nums[i] - (long) t) <= (long) nums[i] + (long) t) {
                return true;
            }
            rec.add((long) nums[i]);
            if (rec.size() == k + 1){
                rec.remove((long)nums[i - k]);
            }
        }
        return false;
    }

    private static void printBool(boolean b){
        System.out.println(b ? "True" : "False");
    }

    public static void main(String[] args) {

        int[] nums = {-2147483648, -2147483647};
        int k = 3;
        int t = 3;
        printBool((new containsNearbyAlmostDuplicate()).containsNearbyAlmostDuplicate(nums, k, t));
    }
}


////该问题是前两道同样题目名的拓展版，仅仅为返回条件不同，该返回条件涉及到两个知识点，一个是ceiling的概念，即比传入参数大的最小数，这一点就需要进行排序，但是treeset自带排序
///复杂度为nlogn，所以改用treeset
///问题二是遇到了整形溢出的问题，需要转long来解决