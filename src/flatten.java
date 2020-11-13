public class flatten {
    public void flatten(TreeNode root) {
        if (root == null) return;
        if (root.right == null && root.left == null) return;
        if (root.left != null) {
            flatten(root.left);
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode curr = root.right;
            while (curr.right != null) curr = curr.right;
            curr.right = temp;
        }
        flatten(root.right);
    }
}
