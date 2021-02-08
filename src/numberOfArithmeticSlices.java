import java.util.Arrays;

public class numberOfArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        //首先设置dp[i]为到索引i位置时，当前子序列所包含的等差子序列数量
        //动态转移方程：dp[i+1] = dp[i] + 1, 条件为 A[i+1] - A[i] == A[i] - A[i-1]
        //最后计算dp求和即为答案
        int n = A.length;
        if (n<3)return 0;
        int[] dp = new int[n];
        for (int i = 1; i < n-1; i++) {
            if (A[i+1] - A[i] == A[i] - A[i-1]){
                dp[i+1] = dp[i] + 1;
            }
        }
        return Arrays.stream(dp).sum();
    }
}
