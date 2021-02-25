import java.util.*;

public class permutations {
    //回溯法的状态变量为：深度depth, 路径path，记忆访问数组used
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;
        boolean[] used = new boolean[len];

        dfs(nums, len, 0, used, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, boolean[] used, List<Integer> path, List<List<Integer>> res) {
        if (depth == len){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, used, path, res);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
