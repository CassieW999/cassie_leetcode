import java.util.PriorityQueue;

public class fulfilmentBuilder {
    public static int connectSticks(int[] sticks) {
        if (sticks == null || sticks.length < 2) return 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int res = 0;
        for (int i = 0; i < sticks.length; i++) {
            minHeap.offer(sticks[i]);
        }
        while (minHeap.size() > 1){
            int first = minHeap.poll();
            int second = minHeap.poll();
            res += first + second;
            minHeap.offer(first + second);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] sticks = {5};
        System.out.println(connectSticks(sticks));
    }
}
