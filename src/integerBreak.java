public class integerBreak {
    //时间：2020-8-16
    //solution 1
//    private static int[] memo;
//    private static int breakInteger(int n) {
//        if (n == 1) return 1;
//        if (memo[n] != 0) {
//            return memo[n];
//        }
//        int max = -1;
//        for (int i = 1; i < n ; i++){
//            max = Math.max(Math.max(i * breakInteger(n - i), max), i * (n - i));
//            memo[n] = max;
//        }
//        return memo[n];
//    }
//    public static int integerBreak(int n) {
//        memo = new int[n+1];
//        return breakInteger(n);
//
//    }
    //solution 2
    public static int integerBreak(int n) {
        int[] memo = new int[n+1];
        memo[1] = 1;
        for (int i = 2; i <= n ; i++){
            for(int j = 1; j <= i - 1; j++){
                memo[i] = Math.max(Math.max(j * (i - j), j * memo[i-j]), memo[i]);
            }
        }
        return memo[n];

    }

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
}
