public class searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int len = m * n;

        int l = 0, r = len - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (matrix[mid/n][mid%n] == target) return true;

            if (matrix[mid/n][mid%n] > target){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return false;
    }
}
