import java.util.ArrayList;
import java.util.List;

public class subArraySumDivisibleByK {
//    Given an array of integers and an integer K, find the number of subarrays which are divisible by K.
//    Input: [3,1,2,5,1], 3
//    Output: 6
//    Explanation: the six subarrays are[3], [3,1,2], [1,2],[5,1], [3,1,2,5,1,], [1,2,5,1]
    public static List<List<Integer>> subArraySumDivisibleByK(int[] nums, int k){
        //[3, 4, 6, 11, 12]
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        int[] arrSum = new int[n];
        for (int i = 1; i < n; i++) {
            arrSum[i] = arrSum[i-1] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            if (arrSum[i] % k == 0){
                addToRes(res, nums, -1, i);// (]
            }
            for (int j = 0; j < i; j++) {
                if ((arrSum[i] - arrSum[j]) % k == 0){
                    addToRes(res, nums, j, i);
                }
            }
        }
        return res;
    }

    private static void addToRes(List<List<Integer>> res, int[] nums, int i, int j) {
        List<Integer> path = new ArrayList<>();
        for (int k = i + 1; k <= j; k++) {
            path.add(nums[k]);
        }
        res.add(path);
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2,5,1};
        int k = 3;
        System.out.println(subArraySumDivisibleByK(nums, k));
    }
}
