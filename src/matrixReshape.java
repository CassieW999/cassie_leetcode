

public class matrixReshape {
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length != 0 || r * c != nums.length * nums[0].length) {
            return nums;
        }
        int[][] res = new int[r][c];
        int m = nums.length;
        int n = nums[0].length;
        for (int i = 0; i < m * n; i++){
            int old_row = i / n;
            int old_col = i % n;
            int new_row = i / c;
            int new_col = i % c;
            res[new_row][new_col] = nums[old_row][old_col];
        }
        return res;
//        int[][] newNums = new int[r][c];
//        Queue<Integer> queue = new LinkedList();
//        if (nums.length * nums[0].length == r * c){
//            for (int i = 0; i < nums.length; i++) {
//                for (int j = 0; j < nums[0].length; j++) {
//                    queue.add(nums[i][j]);
//                }
//            }
//            for (int i = 0; i < r; i++) {
//                for (int j = 0; j < c; j++) {
//                    newNums[i][j] = queue.remove();
//                }
//            }
//            return newNums;
//        }else {
//            return nums;
//        }
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2},{3,4}};
        matrixReshape(nums, 1, 4);
    }
}
