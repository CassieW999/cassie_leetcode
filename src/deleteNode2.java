public class deleteNode2 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key){
            TreeNode rightLeast = getRightLeast(root);
            root.val = rightLeast.val;
            deleteNode(root.right, rightLeast.val);
        }else if (root.val > key){
            deleteNode(root.left, key);
        }else{
            deleteNode(root.right, key);
        }
        return root;
    }

    private TreeNode getRightLeast(TreeNode root) {
        TreeNode right = root.right;
        while (right.left != null){
            right = right.left;
        }
        return right;
    }

}
