import java.util.Arrays;

public class canPartition {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        int target = sum / 2, n = nums.length;
        boolean[][] dp = new boolean[n][sum + 1];
        //状态定义：dp[i][j]表示从数组的 [0, i] 这个子区间内挑选一些正整数，使得这些数的和恰好等于 j。
        //状态转移方程：dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]]
        //dp[0]
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++){
                dp[i][j] = dp[i - 1][j];
                if (nums[i] == j){
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[n-1][target];
    }
}
