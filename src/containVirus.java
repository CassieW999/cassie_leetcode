public class containVirus {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] A = new double[102][102];
        A[0][0] = poured;
        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i][j] > 1){
                    A[i+1][j] += (A[i][j] - 1) / 2;
                    A[i+1][j+1] += (A[i][j] - 1) / 2;
                }
            }
        }
        return Math.min(1,A[query_row][query_glass]);
    }
}
