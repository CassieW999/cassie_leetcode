public class Problem4 {

    public static void main(String[] args) {
        // input matrix
        int[][] firstMatrix = {
                {3, -2, 5},
                {3, 0, 4}
        };
        int[][] secondMatrix = {
                {2, 3},
                {-9, 0},
                {0, 4}
        };

        // Input your code here:
        int len = firstMatrix.length;
        int temp = secondMatrix.length;
        int [][] product = new int[len][len];

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                for(int k = 0; k < temp; k++) {
                    product[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }

        displayProduct(product);
    }

    public static void displayProduct(int[][] product) {
        System.out.println("Product of two matrices is: ");
        for(int[] row : product) {
            for (int column : row) {
                System.out.print(column + "    ");
            }
            System.out.println();
        }
    }
}
