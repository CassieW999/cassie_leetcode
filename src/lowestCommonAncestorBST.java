public class lowestCommonAncestorBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) return root;

        if (root == a || root == b) {
            return root;
        }

        // find left and right matching nodes
        TreeNode l = lowestCommonAncestor(root.left, a,b);
        TreeNode r = lowestCommonAncestor(root.right, a,b);

        if(l!= null && r!= null) { // if both found meaning root is lca
            return root;
        }
        if (l!= null) return l;
        if (r!= null) return r;

        return null;
    }
}
