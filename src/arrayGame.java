import java.util.ArrayList;
import java.util.List;

public class arrayGame {
    public static int countAnalogousArrays(List<Integer> consecutiveDifference, int lowerBound, int upperBound) {
        // Write your code here
        if (consecutiveDifference == null || consecutiveDifference.size() == 0) return 0;
        int n = consecutiveDifference.size();
        int count = 0;
        long min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int prev = lowerBound, cur = 0;
        for (int i = 0; i < n; i++){
            cur = prev - consecutiveDifference.get(i);
            min = Math.min(min, cur);
            max = Math.max(max, cur);
            prev = cur;
        }
        while (max <= upperBound){
            if (min >= lowerBound) count++;
            min++;
            max++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {-2, -1, -2, 5};
        List<Integer> list = new ArrayList<>();
        list.add(-2);
        list.add(-1);
        list.add(-2);
        list.add(5);
        int ans = countAnalogousArrays(list, 3, 10);
        System.out.println(ans);
//        if (788256678 + 49986287 > Integer.MAX_VALUE){
//            System.out.println(true);
//        }else{
//            System.out.println(false);
//        }
    }
}
