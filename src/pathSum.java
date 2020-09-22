import java.util.*;

public class pathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        if (root.left == null && root.right == null){
            if (root.val == sum){
                List<Integer> ans = new ArrayList<>();
                ans.add(root.val);
                res.add(ans);
            }else {
                return res;
            }
        }

        List<List<Integer>> left = pathSum(root.left, sum - root.val);
        List<List<Integer>> right = pathSum(root.right, sum - root.val);
        if (left.size() > 0){
            for (List<Integer> path : left){
                path.add(0, root.val);
                res.add(path);
            }
        }
        if (right.size() > 0){
            for (List<Integer> path : right){
                path.add(0, root.val);
                res.add(path);
            }
        }
        return res;
    }
}
