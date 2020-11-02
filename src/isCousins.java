import java.util.*;

public class isCousins {
    public boolean isCousins(TreeNode root, int x, int y){
        if(root == null) return false;
        Queue<TreeNode> current = new ArrayDeque<>();
        current.add(root);
        TreeNode[] seenParents = new TreeNode[2];
        while (current!= null){
            int size = current.size(), seen = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = current.poll();
                if (node.left != null){
                    if (node.left.val == x || node.left.val == y){
                        seenParents[seen] = node;
                        seen++;
                    }
                    current.add(node.left);
                }
                if (node.right != null){
                    if (node.right.val == x || node.right.val == y){
                        seenParents[seen] = node;
                        seen++;
                    }
                    current.add(node.right);
                }
                if (seen == 1) return false;
                if (seen == 2) return seenParents[0] != seenParents[1];
            }
        }
        return false;
    }
}
