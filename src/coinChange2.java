import java.util.Arrays;

public class coinChange2 {
    public int coinChange(int[] coins, int amount) {
        //完全背包问题
        //def: dp[i][j] = v, 即 使用前i种硬币构成总数为j的金额最少需要v枚硬币
        //状态转移方程: dp[i][j] = min(dp[i][j], dp[i][j - coin_i] + 1)
        int n = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }
        return dp[amount];
    }
}
