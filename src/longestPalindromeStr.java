public class longestPalindromeStr {
    public static String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++){
            dp[i][i] = true;
        }
        for (int len = 2; len <= n; len++){
            for (int i = 0; i + len <= n; i++){
                int right = i + len - 1;
                if (s.charAt(i) == s.charAt(right)){
                    if (len == 2 || dp[i+1][right-1]){
                        dp[i][right] = true;
                        if (len > maxLen){
                            maxLen = len;
                            begin = i;
                        }
                    }
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        String s = "abdka";
        System.out.println(longestPalindrome(s));
    }
}
