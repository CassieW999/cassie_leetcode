public class pathSum3 {
    public int pathSum(TreeNode root, int sum){
        if (root == null) return 0;

        int res = findpath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        return res;
    }

    private int findpath(TreeNode node, int num){
        if (node == null) return 0;

        int res = 0;
        if (node.val == num) res += 1;

        res += findpath(node.left, num - node.val);
        res += findpath(node.right, num - node.val);

        return res;
    }
}
