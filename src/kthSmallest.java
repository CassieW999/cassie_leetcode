import java.util.ArrayList;
import java.util.List;

public class kthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> sortedList = helper(root);
        return sortedList.get(k-1);
    }

    public List<Integer> helper(TreeNode root){

        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        res.addAll(helper(root.left));
        res.add(root.val);
        res.addAll(helper(root.right));
        return res;
    }



}
