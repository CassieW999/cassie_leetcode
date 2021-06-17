//public class canJump {
//    public boolean canJump(int[] nums) {
//        int n = nums.length;
//        int rightMostPos = 0;
//        for (int i = 0; i <= rightMostPos; i++) {
//            rightMostPos = Math.max(rightMostPos, nums[i] + i);
//            if (rightMostPos >= n - 1) return true;
//        }
//        return false;
//    }
//
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        if (preorder.length != inorder.length || preorder.length == 0) return null;
//
//        int headValue = preorder[0];
//        TreeNode head = new TreeNode(headValue);
//        int headIndex = findIndex(inorder, headValue);
//        TreeNode left_sub = buildTree(preorder.);
//        TreeNode right_sub = buildTree();å
//        head.left = left_sub;
//        head.right = right_sub;
//        return head;
//    }
//}
