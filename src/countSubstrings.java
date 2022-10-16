public class countSubstrings {
    public static int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        for (int i = 0; i < n; i++){
            dp[i][i] = true;
            count++;
        }

        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "aaaaa";
        System.out.println(countSubstrings(s));
    }
}
