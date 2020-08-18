public class climbingstairs {
    public static int climbStairs(int n) {
        int[] memo = new int[n+1];
        if (n == 0 || n == 1){
            return 1;
        }
        memo[0] = 1;
        memo[1] = 1;

        for (int i = 2; i <= n; i++){
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n];
    }

    public static void main(String[] args) {
        climbStairs(10);
        System.out.println(climbStairs(10));
    }
}
