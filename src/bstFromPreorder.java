public class bstFromPreorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        int len = preorder.length;
        if (len == 0) {
            return null;
        }

        return buildBST(preorder, 0, len - 1);
    }

    private TreeNode buildBST(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[left]);
        if (left == right) {
            return root;
        }
        int leftPoint = left;
        int rightPoint = right;

        while (leftPoint < rightPoint) {
            int mid = leftPoint + (rightPoint - leftPoint + 1) / 2;
            if (preorder[mid] < preorder[left]) {
                leftPoint = mid;
            } else {
                rightPoint = mid - 1;
            }
        }

        TreeNode leftTree = buildBST(preorder, left + 1, leftPoint);
        TreeNode rightTree = buildBST(preorder, leftPoint + 1, right);

        root.left = leftTree;
        root.right = rightTree;
        return root;
    }
}
