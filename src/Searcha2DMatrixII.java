public class Searcha2DMatrixII {
    public static boolean searchMatrix(int[][] matrix, int target) {
        ///////////      solution one      //////////////
//        int row = matrix.length;
//        if (row == 0) return false;
//        int cols = matrix[0].length;
//        for (int i = 0; i < row; i++){
//            for (int j = 0; j < cols; j++){
//                if (matrix[i][j] == target) return true;
//            }
//        }
//        return false;


        ////////////      solution two      /////////////////
        int row = matrix.length;
        if (row == 0) return false;
        int cols = matrix[0].length;

        int i = 0, j = cols - 1;

        while(i < row && j >= 0){
            if(matrix[i][j]==target)
                return true;
            else if(matrix[i][j]>target)
                j--;
            else
                i++;
        }
        return false;

    }

    public static void main(String[] args) {
        int[][] matrix = {{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
        int[][] matrix1 = {{}};
        int target = 26;
        System.out.println(searchMatrix(matrix,target));
        System.out.println(searchMatrix(matrix1,target));
    }
}
