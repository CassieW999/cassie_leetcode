public class findMaxForm {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for (String str : strs){
            int ones_num = countNum(str, "1");
            int zeros_num = countNum(str, "0");
            for (int i = m; i >= zeros_num; i--) {
                for (int j = n; j >= ones_num; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-zeros_num][j-ones_num]+1);
                }
            }
        }
        return dp[m][n];
    }

    private int countNum(String str, String var){
        int strlen = str.length();
        String newstr = str.replaceAll(var, "");
        int newlen = newstr.length();
        return strlen - newlen;
    }
}
