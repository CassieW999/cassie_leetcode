public class HouseRobber {
    public static int[] memo;

    public static int rob(int[] nums) {
        //memo记录从考虑[i, n-1]抢劫获得的最大收益
        return tryrob(nums, 0);
    }

    //index为考虑抢劫的开始索引
    private static int tryrob(int[] nums, int index){
        //solution1
//        if (index >= nums.length) return 0;
//        int[] memo = new int[nums.length];
//        if (memo[index] > 0) return memo[index];
//        int max = -1;
//        for (int i = index; i < nums.length; i++){
//            max = Math.max(max, nums[i] + tryrob(nums, i + 2));
//            memo[index] = max;
//        }
//        return memo[index];
        //solution 2
        if (nums.length == 0) return 0;
        //memo记录从考虑[i, n-1]抢劫获得的最大收益
        int[] memo = new int[nums.length];

        memo[nums.length-1] = nums[nums.length-1];
        for (int i = nums.length-2; i>=0;i--){
            for(int j = i; j<nums.length; j++){
                memo[i] = Math.max(memo[i], nums[j] + (j+2<nums.length ? memo[j+2]:0) );
            }
        }
        return memo[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        int res = rob(nums);
        System.out.println(res);
    }
}
