public class maxPathSum {
    private int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        helper(root);
        return maxSum;
    }

    private int helper(TreeNode root){
        if (root == null)return 0;

        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        maxSum = Math.max(maxSum, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
