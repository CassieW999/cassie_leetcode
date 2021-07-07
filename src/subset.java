import java.util.ArrayList;
import java.util.List;

public class subset {
    public static List<List<Integer>> subset(int[] nums){
        List<List<Integer>> res =  new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(res, nums, 0, path);
        return res;
    }

    private static void dfs(List<List<Integer>> res, int[] nums, int i, List<Integer> path) {
        if (i == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        dfs(res, nums, i+1, path);

        path.add(nums[i]);
        dfs(res, nums, i+1, path);
        path.remove(path.size() - 1);
    }

    public static List<List<Integer>> combine(int n, int k){
        List<List<Integer>> res =  new ArrayList<>();
//        boolean[] visited = new boolean[n + 1];
        dfsForCombine(n, k, res, new ArrayList<>(), 0);
        return res;
    }

    private static void dfsForCombine(int n, int k, List<List<Integer>> res, List<Integer> path, int index) {
        if (path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i <= n; i++) {
            path.add(i);
            dfsForCombine(n, k, res, path, i+1);
            path.remove(path.size() - 1);
        }
    }

    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res =  new ArrayList<>();
        dfsForPermute(nums, res, new ArrayList<>());
        return res;
    }

    private static void dfsForPermute(int[] nums, List<List<Integer>> res, List<Integer> path) {
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (path.contains(nums[j])) continue;
            path.add(nums[j]);
            dfsForPermute(nums, res, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
//        List<List<Integer>> ans = subset(nums);
//        System.out.println(ans);

//        int n = 4, k = 2;
//        System.out.println(combine(n, k));

        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }
}
