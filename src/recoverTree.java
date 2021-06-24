import java.util.ArrayList;
import java.util.List;

public class recoverTree {
//     public class TreeNode {
//         int val;
//         TreeNode left;
//         TreeNode right;
//         TreeNode() {}
//         TreeNode(int val) { this.val = val; }
//         TreeNode(int val, TreeNode left, TreeNode right) {
//             this.val = val;
//             this.left = left;
//             this.right = right;
//         }
//     }

    public void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        getInorderNums(root, nums);
        int[] swapNums = getSwapNums(nums);
        recover(swapNums[0], swapNums[1], root, 2);
    }

    public void getInorderNums(TreeNode node, List<Integer> nums){
        if (node == null) return;
        getInorderNums(node.left, nums);
        nums.add(node.val);
        getInorderNums(node.right, nums);
    }

    public int[] getSwapNums(List<Integer> nums){
        int x = -1, y = -1;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i+1) < nums.get(i)){
                y = nums.get(i+1);
                if (x == -1){
                    x = nums.get(i);
                }
            }
        }
        return new int[]{x, y};
    }

    public void recover(int x, int y, TreeNode node, int count){
        if (count == 0)return;

        if (node.val == x || node.val == y){
            node.val = node.val == x ? y : x;
            count--;
        }
        recover(x, y, node.left, count);
        recover(x, y, node.right, count);
    }
}
