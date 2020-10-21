import java.util.*;

public class postorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur!=null){
                result.add(cur.val);
                stack.push(cur.left);
                stack.push(cur.right);

            }
        }
        Collections.reverse(result);
        return result;
    }
}
