import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class binaryTreeLevelTraversal {
    public List<List<Integer>> binaryTreeLevelTraversal(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> path = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                path.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            res.add(path);
        }
        return res;
    }
}
