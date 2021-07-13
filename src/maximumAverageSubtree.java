public class maximumAverageSubtree {
    public double maximumAverageSubtree(TreeNode root) {
        if (root == null) return 0;
        int sum = getSum(root);
        int count = getCount(root);
        double cur = sum / count;
        double max = cur;
        max = Math.max(max, maximumAverageSubtree(root.left));
        max = Math.max(max, maximumAverageSubtree(root.right));
        return max;
    }

    public int getCount(TreeNode node){
        if (node == null) return 0;
        return getCount(node.left) + getCount(node.right) + 1;
    }

    public int getSum(TreeNode node){
        if (node == null)return 0;
        return getSum(node.left) + getSum(node.right) + node.val;
    }
}
