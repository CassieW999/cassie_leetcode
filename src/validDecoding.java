public class validDecoding {
    public int validDecoding(String str){
        int[] cost = new int[str.length() + 2];
        cost[1] = 1;
        for (int i = 0; i < str.length(); i++) {
            cost[i+2] = cost[i+1];
            if (i != 0){
                int twoDigit = (str.charAt(i-1) - '0') * 10 + (str.charAt(i) - '0');
                if (twoDigit >= 10 && twoDigit < 26){
                    cost[i+2] += cost[i];
                }
            }
        }
        return cost[cost.length - 1];
    }
}
