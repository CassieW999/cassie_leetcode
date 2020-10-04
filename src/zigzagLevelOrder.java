import java.util.ArrayList;
import java.util.List;

public class zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        int levelNum = 0;
        if (root == null) return res;
        helper(root, levelNum, res);
        orderList(res);
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

    public void orderList(List<List<Integer>> res){
        if (res.size() == 0) return;

        for (int i = 0; i < res.size(); i++){
            if (i % 2 == 1){
                res.set(i,reverse(res.get(i)));
            }
        }
    }

    public List<Integer> reverse(List<Integer> list){
        List<Integer> newList = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            newList.add(list.get(i));
        }
        return newList;
    }
}
