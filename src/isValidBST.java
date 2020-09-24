public class isValidBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode node, Integer low, Integer up){
        if (node == null) return true;

        int val = node.val;
        if (low != null && val <= low) return false;
        if (up != null && val >= up) return false;

        if (!helper(node.left, null, val)) return false;
        if (!helper(node.right, val, null)) return false;
        return true;
    }
}
