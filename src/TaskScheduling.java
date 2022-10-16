import java.util.Arrays;
import java.util.Comparator;

public class TaskScheduling {
    public static void main(String[] args) {
        int[] cost = {69, 8, 91, 42, 30, 8, 75, 59, 38, 37, 46, 77, 29, 32, 33, 80, 46, 58, 84, 83, 28, 22, 40, 21, 89, 53, 27, 34, 66, 61, 50, 97, 63, 27, 97, 51, 40, 21, 72, 86, 80, 62, 99, 29, 16, 17, 95, 36, 91, 19, 86, 51, 28, 16, 1, 34, 38, 84, 3};
        int[] time = {47, 16, 38, 83, 76, 6, 23, 38, 94, 74, 71, 9, 11, 47, 99, 25, 38, 87, 31, 78, 49, 46, 25, 8, 67, 96, 5, 54, 92, 17, 16, 44, 20, 60, 76, 20, 9, 6, 45, 31, 72, 11, 75, 43, 32, 42, 97, 37, 88, 61, 83, 32, 33, 66, 14, 30, 17, 60, 23};
        int res = getMinCost(cost, time);
        System.out.println(res);
    }

    private static int getMinCost(int[] cost, int[] time) {
        int n = cost.length;
        Task[] tasks = new Task[n];
        for (int i = 0; i < n; i++) {
            Task cur = new Task(i, cost[i], time[i]);
            tasks[i] = cur;
        }
            Arrays.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if (o1.cost != o2.cost) return o1.cost - o2.cost;
                return o2.time - o1.time;
            }
        });
        int l = 0, r = n - 1;
        int res = 0;
            while (l <= r){
            res += tasks[l].cost;
            int period = tasks[l].time;
            l++;
            for (int i = 0; i < period; i++) {
                r--;
            }
        }
            return res;
    }

    static class Task{
        int idx;
        int cost;
        int time;
        public Task(int idx, int cost, int time){
            this.idx = idx;
            this.cost = cost;
            this.time = time;
        }
    }
}
