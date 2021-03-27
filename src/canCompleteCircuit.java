public class canCompleteCircuit {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] sur = new int[2 * n];
        for (int i = 0; i < n; i++){
            sur[i] = gas[i] - cost[i];
            sur[i + n] = sur[i];
        }
        int start = 0;

        while (start < n){
            int sum = 0;
            if (sur[start] < 0) {
                start++;
                continue;
            }
            for (int i = start; i < start + n;i++){
                sum += sur[i];
                if (sum < 0){
                    break;
                }
            }
            if (sum >= 0) return start;
            start++;
        }
        return -1;
    }

    public static int solution2(int[] gas, int[] cost){
        int len = gas.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < len; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }

        return spare < 0 ? -1 : (minIndex + 1) % len;
    }

    public static void main(String[] args) {
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
