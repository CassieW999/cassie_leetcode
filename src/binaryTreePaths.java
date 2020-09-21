import java.util.ArrayList;
import java.util.List;

public class binaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if (root == null) return res;
        if (root.left == null && root.right == null){
            res.add(root.val + "");
        }

        List<String> leftS = binaryTreePaths(root.left);
        List<String> rightS = binaryTreePaths(root.right);

        for (String str : leftS){
            res.add(root.val + "->" + str);
        }
        for (String str : rightS){
            res.add(root.val + "->" + str);
        }
        return res;
    }
}
