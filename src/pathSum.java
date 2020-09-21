import javax.swing.tree.TreeNode;
import java.util.*;

public class pathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> left = pathSum(root.left, sum - root.val);
        List<List<Integer>> right = pathSum(root.right, sum - root.val);
        if (left.size() > 0){
            for (List<Integer> path : left){
                path.add(root.val);
            }
        }
        if (right.size() > 0){
            for (List<Integer> path : right){
                path.add(root.val);
            }
        }
        left.addAll(right);

    }
}
