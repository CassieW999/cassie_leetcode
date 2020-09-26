public class deleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key){
        if (root == null) return null;

        if (root.val > key){
            root.left = deleteNode(root.left, key);
        }else if (root.val < key){
            root.right = deleteNode(root.right, key);
        }else {
            if (root.right == null) return root.left;
            if (root.left == null) return root.right;
            TreeNode minNode = minNode(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    public TreeNode minNode(TreeNode node){
        while (node.left != null){
            node = node.left;
        }
        return node;
    }
}
