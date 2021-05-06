import java.util.ArrayList;
import java.util.List;

public class combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, candidates, target, new ArrayList<Integer>(), 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] candidates, int target, List<Integer> integers, int idx) {
        for (int i = idx; i < candidates.length; i++) {
            if (target - candidates[i] == 0){
                integers.add(candidates[i]);
                res.add(new ArrayList<>(integers));
                integers.remove(integers.size() - 1);
            }else if (target - candidates[i] > 0){
                integers.add(candidates[i]);
                dfs(res, candidates, target - candidates[i], integers, i);

            }
        }
    }
}
