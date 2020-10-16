

public class coinChange {
    public static int coinChange(int[] coins, int amount) {
        if (coins.length == 0 || amount == 0) return -1;
        int index = helper(coins, amount);

        return index;
    }

    public static int helper(int[] coins, int amount){
        if (amount == 0) return 0;
        int res = Integer.MAX_VALUE;
        for (int coin : coins){
            if (amount >= coin){
                int this_res = helper(coins, amount - coin);
                if (this_res != -1){
                    res = Math.min(res, this_res + 1);
                }
            }
        }
        if (res == Integer.MAX_VALUE){
            return -1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] coins= {1,2,5};
        int res = coinChange(coins, 11);
        System.out.println(res);
    }
}
