public class sumNumbers {
    int sum = 0;
    int total = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        sum = sum*10+ root.val;
        if(root.left == null && root.right == null){
            total = total + sum;
        }
        sumNumbers(root.left);
        sumNumbers(root.right);
        sum = (sum - root.val)/10;
        return total;

    }
}
