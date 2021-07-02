

public class isMatch2 {
    public int[][] memo;
    public boolean isMatch(String s, String p) {
        memo = new int[s.length()][p.length()];
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < p.length(); j++){
                memo[i][j] = -1;
            }
        }
        return dp(s, p, 0, 0);
    }

    public boolean dp(String s, String p, int i, int j){
        int m = s.length(), n = p.length();
        if (j == n) return i == m;
        if (i == m){
            while (j + 1 <= n){
                if (j+1 == n || p.charAt(j+1) != '*') return false;
                j += 2;
            }
            return true;
        }
        if (memo[i][j] != -1) return memo[i][j] == 0 ? false : true;
        boolean res = false;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
            if (j < n - 1 && p.charAt(j+1) == '*'){
                // 可以匹配0次或者多次
                res = dp(s, p, i, j+2) || dp(s, p, i+1, j);
            }else{
                // 跳过
                res = dp(s, p, i+1, j+1);
            }
        }else{
            if (j < n - 1 && p.charAt(j+1) == '*'){
                // 匹配0次
                res = dp(s, p, i, j+2);
            }else{
                res = false;
            }
        }
        memo[i][j] = res ? 1 : 0;
        return res;
    }
}
