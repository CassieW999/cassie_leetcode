public class maxProfit4 {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length <= 1 || k == 0) return 0;
        int n = prices.length;
        int maxRes = 0;
        if (k >= n/2) {
            maxRes = maxProfitWithNoLimit(prices);
        }else{
            int[][][] dp = new int[n][2][k+1];//i, j, m: 表示第i天，在进行了j次交易后，状态值为m的情况下的最大利润值
            for (int i = 0; i <= k; i++) { //初始化
                dp[0][0][i] = 0;
                dp[0][1][i] = -prices[0];
            }
            //状态转移方程
            for (int i = 1; i < n; i++) {
                for (int j = 1; j <= k; j++) {
                    dp[i][0][j] = Math.max(dp[i-1][0][j], dp[i-1][1][j]+prices[i]);
                    dp[i][1][j] = Math.max(dp[i-1][1][j], dp[i-1][0][j-1]-prices[i]);
                }
            }
            maxRes = dp[n-1][0][k];
        }
        return maxRes;
    }

    public int maxProfitWithNoLimit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int res = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i - 1]){
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
}
