import java.util.*;

public class threeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3) return new ArrayList<>();

        Set<List<Integer>> set = new HashSet<List<Integer>>();
        Arrays.sort(nums);// Quick sort
        int n = nums.length;
        for(int i=0;i<n-2;i++){
            int left = i+1;
            int right = n-1;
            while (left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum==0)
                    set.add(Arrays.asList(nums[i],nums[left++],nums[right--]));
                else if(sum > 0)
                    right--;
                else
                    left++;
            }
        }

        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        threeSum(nums);
    }
}
