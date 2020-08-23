import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            for (int col = startCol; col <= endCol; col++) {
                result.add(matrix[startRow][col]);
            }
            for (int row = startRow + 1; row <= endRow; row++) {
                result.add(matrix[row][endCol]);
            }
            for (int col = endCol - 1; col >= startCol; col--) {
                if (startRow == endRow) break;
                result.add(matrix[endRow][col]);
            }
            for (int row = endRow - 1; row > startRow; row--) {
                if (startCol == endCol) break;
                result.add(matrix[row][startCol]);
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3, 4},{5, 6, 7, 8},{9,10,11,12}};
        spiralOrder(nums);
    }
}
