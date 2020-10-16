import java.util.*;

public class finalPrices {
    public int[] finalPrices(int[] prices) {
        //////////     solution 1      //////////
//        int n = prices.length;
//        for (int i = 0; i < n; i++){
//            for (int j = i + 1; j < n; j ++){
//                if (prices[j] <= prices[i]){
//                    prices[i] = prices[i] - prices[j];
//                    break;
//                }
//            }
//        }
//        return prices;


        //////////     solution 2     //////////
        Stack<Integer> stack = new Stack<Integer>();
        for (int i=0; i<prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i])
                prices[stack.pop()] -= prices[i];
            stack.push(i);
        }
        return prices;
    }
}
