public class HouseRobber2 {
    //这题比houseRobber1添加了一个步骤，将一个变量变成了两个变量，原因是如果从第一个房子开始考虑则不能考虑最后一个房子，如果从第二个房子开始则考虑到最后一个
    public static int rob(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;

        if(nums.length==1)
            return nums[0];

        int max1 = robHelper(nums, 0, nums.length-2);
        int max2 = robHelper(nums, 1, nums.length-1);

        return Math.max(max1, max2);
    }

    //辅助函数为计算考虑范围为[i,j]时，能偷取的最大值
    public static int robHelper(int[] nums, int i, int j){
        int n = nums.length;
        if(i==j){
            return nums[i];
        }
        int[] memo = new int[n];
        memo[j] = nums[j];
        for (int a = j - 1; a >= i; a--){
            for(int b = a; b <= j; b++){
                memo[a] = Math.max(memo[a], nums[b] + (b+2>j ? 0 : memo[b+2]));
            }
        }
        return memo[i];
    }

    public static void main(String[] args) {
        int[] nums = {2,3,2};
        System.out.println(rob(nums));
    }
}
