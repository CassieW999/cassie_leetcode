import java.util.*;

public class combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[n];
        dfs(n, k, res, new ArrayList<>(), used, 0, 0);
        return res;
    }

    private void dfs(int n, int k, List<List<Integer>> res, List<Integer> path, boolean[] used, int depth, int prev) {
        if (depth == k){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = prev + 1; i <= n; i++) {//i代表数值
            if (used[i-1]){
                continue;
            }
            path.add(i);
            used[i - 1] = true;
            dfs(n, k, res, path, used, depth + 1, i);
            path.remove(path.size() - 1);
            used[i - 1] = false;
        }
    }
}
