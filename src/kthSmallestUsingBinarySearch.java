public class kthSmallestUsingBinarySearch {
    public int kthSmallest(int[][] matrix, int k) {
        //in matrix[0][0] --> matrix[-1][-1] range,
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        while(left < right){
            int mid = left + (right - left)/2;
            int total = 0;
            for (int[] row : matrix){
                total += upper_bound(row, mid);
            }
            if (total >= k) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public int upper_bound(int[] row, int value){
        int low = 0;
        int high = row.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (value >= row[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
