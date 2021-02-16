public class maxProfitWithCooldown {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int n = prices.length;
        int[][] dp = new int[n][3];//dp[i][j] 表示在第i天结束后的，当状态值为j时，最大利润值
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        for (int i = 1; i < n; i++) {
            //如果当天不持有股票，且不处于冷冻期，那么前一天没有卖出股票，即前一天也没有持有股票，因此可能是0和2两种状态
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2]);
            //如果当天持有股票，那么如果前一天有股票，则前一天状态为1，如果前一天没有股票，那么必然是今天买了股票，即前一天不是冷冻期
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
            //如果当天是冷冻期，一定是当天卖了股票，即前一天状态必然为持有股票
            dp[i][2] = dp[i-1][1] + prices[i];
        }
        return Math.max(dp[n-1][0], dp[n-1][2]);
    }
}
