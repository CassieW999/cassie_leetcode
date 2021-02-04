public class longestPalindrome {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";

        for (int j = 0; j < n; j++){
            for(int i = 0; i <= j; i++){
                if (i == j){
                    dp[i][j] = true;
                }else if (i == j - 1){
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }else{
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if(dp[i][j] && j - i + 1 > ans.length()){
                    ans = s.substring(i, j+1);
                }
            }
        }
        return ans;
    }
}
