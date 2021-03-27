import java.util.LinkedList;
import java.util.Queue;

public class jump2 {
    public static int jump(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        int min = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while(!q.isEmpty()){
            min++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                for (int j = 1; j <= nums[curr]; j++) {
                    if (curr + j == n - 1){
                        return min;
                    }
                    if (curr + j < n && !visited[curr + j]){
                        q.offer(curr + j);
                        visited[curr + j] = true;
                    }
                }
            }
        }
        return n - 1;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int ans = jump(nums);
        System.out.println(ans);
    }
}
