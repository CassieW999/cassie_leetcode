import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class preorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if (cur != null){
                res.add(cur.val);
                stack.push(cur.right);
                stack.push(cur.left);
            }
        }
        return res;
    }
}
