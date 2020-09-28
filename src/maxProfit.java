import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class maxProfit {
    public int maxProfit(int[] prices) {
        // int maxprofit = 0;
        // for (int i = 0; i < prices.length - 1; i++) {
        //     for (int j = i + 1; j < prices.length; j++) {
        //         int profit = prices[j] - prices[i];
        //         if (profit > maxprofit)
        //             maxprofit = profit;
        //     }
        // }
        // return maxprofit;
        List<Integer> list = Arrays.asList(prices);
        Collections.sort(list);
        return list.get(list.size()-1) - list.get(0);
    }
}
