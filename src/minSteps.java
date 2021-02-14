public class minSteps {
    public int minSteps(int n) {
        //dp[i]为 为了达到n个a最少需要进行多少次操作
        //为了达到dp[i]有两种方法，
        //1。一种是直接复制当前粘贴板数量的a，步骤数量加一
        //2。另一种是先复制全部，再粘贴
        // goal: aaaaaa
        // aaa aaa ： aaa + 2
        // aa aa aa : aa + 3
        // a a a a a a: a + 6
        // for i
        //      for j
        // 如果是公约数，则 dp[i] = min(dp[i], dp[i/j] + j)

        int[] dp = new int[n+1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++){
            dp[i] = i;
            for (int j = 2; j <= i; j++){
                if (i % j == 0){
                    dp[i] = Math.min(dp[i], dp[i/j] + j);
                }
            }
        }
        return dp[n];
    }
}
