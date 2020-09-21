import javax.swing.tree.TreeNode;

public class sumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) { return 0;}
        int sum =sumOfLeftLeaves( root.left)+sumOfLeftLeaves( root.right);
        return (root.left!=null && root.left.left==null && root.left.right==null)?sum+ root.left.val:sum+0;
    }
}
