import java.util.ArrayList;
import java.util.List;

public class levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        int levelNum = 0;
        if (root == null) return res;
        helper(root, levelNum, res);

        return res;
    }

    public void helper(TreeNode root, int levelNum, List<List<Integer>> res){
        if (root == null)  return;
        List<Integer> temp = new ArrayList<>();
        if (res.size() <= levelNum){
            temp.add(root.val);
            res.add(temp);
        }else {
            temp = res.get(levelNum);
            temp.add(root.val);
            res.set(levelNum, temp);
        }
        levelNum++;
        helper(root.left, levelNum, res);
        helper(root.right, levelNum, res);
    }
}
