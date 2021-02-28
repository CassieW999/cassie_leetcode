import java.util.ArrayList;
import java.util.List;

public class binaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        dfs(res, "", root);
        return res;
    }

    public void dfs(List<String> res, String path, TreeNode root){
        if (root != null){
            StringBuffer sb = new StringBuffer(path);
            sb.append(root.val);
            if (root.left == null && root.right == null){
                res.add(sb.toString());
            }else{
                sb.append("->");
                dfs(res, sb.toString(), root.left);
                dfs(res, sb.toString(), root.right);
            }
        }
    }
}
