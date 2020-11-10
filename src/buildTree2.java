import java.util.Arrays;

public class buildTree2 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n  = postorder.length;
        if( n == 0)
            return null;
        TreeNode root = new TreeNode(postorder[n-1]);
        if(n == 1)
            return root;
        int l =0;
        for(int i =0; i<postorder.length; i++){
            if(postorder[n-1] == inorder[i]){
                l = i;
            }
        }

        root.left = buildTree(Arrays.copyOfRange(inorder,0, l), Arrays.copyOfRange(postorder, 0,l));
        root.right = buildTree(Arrays.copyOfRange(inorder,l+1, n), Arrays.copyOfRange(postorder,l ,n-1));
        return root;
    }
}
