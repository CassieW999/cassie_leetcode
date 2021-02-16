public class maxProfit3 {
    public int maxProfit(int[] prices){
        if (prices == null || prices.length <= 1) return 0;
        int n = prices.length;
        int[] p1 = new int[n];//p1[i]表示在第i空处切割时，
        int[] p2 = new int[n];

        int low = prices[0];

        for (int i = 1; i < n; i++) {
            p1[i] = Math.max(p1[i-1], prices[i] - low);
            low = Math.min(low, prices[i]);
        }

        int high = prices[n-1];
        for (int j = n-2; j >= 0; j--) {
            p2[j] = Math.max(p2[j+1], high - prices[j]);
            high = Math.max(high, prices[j]);
        }

        int res = 0;
        for (int index = 0; index < n; index++) {
            res = Math.max(res, p1[index] + p2[index]);
        }
        return res;
    }
}
