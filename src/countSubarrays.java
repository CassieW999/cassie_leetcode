import java.util.LinkedList;

public class countSubarrays {
    public static long countSubarrays(int[] nums, int minK, int maxK) {
        int left = 0, right = 0;
        int n = nums.length;
        MaxMonotonicQueue maxQ = new MaxMonotonicQueue();
        MinMonotonicQueue minQ = new MinMonotonicQueue();
        long count = 0;
        while (right < n){
            int r = nums[right++];
            if (r < minK || r > maxK){
                maxQ = new MaxMonotonicQueue();
                minQ = new MinMonotonicQueue();
                left++;
                continue;
            }
            maxQ.push(r);
            minQ.push(r);

            if (maxQ.max() == maxK && minQ.min() == minK){
                count++;
                while (nums[left] != maxQ.max() && nums[left] != minQ.min()) {
                    count++;
                    minQ.pop(nums[left]);
                    maxQ.pop(nums[left]);
                    left++;
//                    hhhh
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1};
        int min = 1;
        int max = 1;
        System.out.println(countSubarrays(nums, min, max));
    }
}

class MinMonotonicQueue {
    LinkedList<Integer> q = new LinkedList<>();

    public void push(int n){
        while (!q.isEmpty() && q.getLast() > n){
            q.pollLast();
        }
        q.addLast(n);
    }

    public int min(){
        return q.getFirst();
    }

    public void pop(int n){
        if (n == q.getFirst()) q.pollFirst();
    }
}

class MaxMonotonicQueue {
    LinkedList<Integer> q = new LinkedList<>();

    public void push(int n){
        while (!q.isEmpty() && q.getLast() < n){
            q.pollLast();
        }
        q.addLast(n);
    }

    public int max(){
        return q.getFirst();
    }

    public void pop(int n){
        if (n == q.getFirst()) q.pollFirst();
    }
}
