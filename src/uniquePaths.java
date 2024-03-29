public class uniquePaths {
    public static int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int dp[][] = new int[m + 1][n + 1];
        dp[1][1] = 1;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (i == 1 && j == 1) {
                    dp[1][1] = 1;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int res = uniquePaths(3,2);
        System.out.println(res);
    }
}
