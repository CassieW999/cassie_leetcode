import java.util.ArrayList;

public class DoomsdayFuelUsingFrac {
    public static void main(String[] args) {
        int[][] m = {{0, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 0, 0},{4, 0, 0, 3, 2, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};
        int[] ans = solutionFuel(m);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    public static int[] solutionFuel(int[][] m) {
        int len = m.length;
        if (len < 2) return  new int[]{1,1};
        ArrayList<ArrayList<Fraction>> nonTerminals = new ArrayList<>();
        int countNonTerm = 0;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = 0; j < len; j++) {
                sum += m[i][j];
            }
            if (sum == 0){
                countNonTerm++;
            }
            if (i == 0 && sum == 0){
                int[] ans_zero = new int[len + 1];
                ans_zero[0] = 1;
                ans_zero[len] = 1;
                return ans_zero;
            }
            ArrayList<Fraction> row = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                if (sum != 0){
                    row.add(new Fraction(m[i][j], sum));
                }
            }
            nonTerminals.add(row);
        }

        while (countNonTerm > 0){
            nonTerminals.remove(nonTerminals.size() - 1);
            countNonTerm--;
        }


        ArrayList<ArrayList<Fraction>> QMatrix= getQ(nonTerminals);
        ArrayList<ArrayList<Fraction>> IMatrix= getI(QMatrix.size());
        ArrayList<ArrayList<Fraction>> RMatrix= getR(nonTerminals, len);
//        ArrayList<ArrayList<Fraction>> QMinusI= matrixMinus(QMatrix, IMatrix);
        Matrix Q = new Matrix(QMatrix, QMatrix.size(), QMatrix.size());
        Matrix R = new Matrix(RMatrix, RMatrix.size(), RMatrix.size() > 0 ? RMatrix.get(0).size() : 0);
        Matrix I = new Matrix(IMatrix, IMatrix.size(), IMatrix.size());
        Matrix QMinusIMatrix = I.minus(Q);
        Matrix reversedQMinusI= QMinusIMatrix.getInverseMatrix();
        Matrix multi = reversedQMinusI.multiply(R);
        ArrayList<Fraction> ans_raw = multi.getRow(0);
        int[] ans = findFinalAns(ans_raw);
        return ans;
    }

    private static int[] findFinalAns(ArrayList<Fraction> num) {
        ArrayList<Fraction> numeratorList = new ArrayList<Fraction>();
        int[] denomList = new int[num.size()];
        for (int i = 0; i < num.size(); i++) {
            denomList[i] = num.get(i).getDenominator();
            numeratorList.add(num.get(i));
        }
        int lcm = getLcm(denomList);
        int[] result = new int[num.size()+1];
        for (int j = 0; j < result.length-1; j++) {
            numeratorList.set(j, numeratorList.get(j).multiply(new Fraction(lcm)));
            result[j] = numeratorList.get(j).getNumerator();
        }
        result[num.size()] = lcm;
        return result;
    }

    private static int getLcm(int[] nums) {
        long lcm = 1;
        int divisor = 2;

        while (true) {
            int counter = 0;
            boolean divisible = false;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    return 0;
                }
                else if (nums[i] < 0) {
                    nums[i] = nums[i] * (-1);
                }
                if (nums[i] == 1) {
                    counter++;
                }
                if (nums[i] % divisor == 0) {
                    divisible = true;
                    nums[i] = nums[i] / divisor;
                }
            }
            if (divisible) {
                lcm = lcm * divisor;
            }
            else {
                divisor++;
            }
            if (counter == nums.length) {
                return (int)lcm;
            }
        }
    }

    private static ArrayList<ArrayList<Fraction>> multiplyMatrix(ArrayList<ArrayList<Fraction>> firstMatrix, ArrayList<ArrayList<Fraction>> secondMatrix) {
        int r1 = firstMatrix.size();
        int c1 = firstMatrix.get(0).size();
        int c2 = secondMatrix.get(0).size();

        ArrayList<ArrayList<Fraction>> ans = new ArrayList<ArrayList<Fraction>>();
        for(int i = 0; i < r1; i++) {
            ArrayList<Fraction> row = new ArrayList<Fraction>();
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    row.add(firstMatrix.get(i).get(k).multiply(secondMatrix.get(k).get(j)));
                }
            }
            ans.add(row);
        }
        return ans;
    }

    private static ArrayList<ArrayList<Fraction>> getR(ArrayList<ArrayList<Fraction>> nonTerminals, int size) {
        int len = nonTerminals.size();
        ArrayList<ArrayList<Fraction>> ans = new ArrayList<ArrayList<Fraction>>();
        for (int i = 0; i < len; i++) {
            ArrayList<Fraction> row = new ArrayList<Fraction>();
            for (int j = 0; j < size - len; j++) {
                row.add(nonTerminals.get(i).get(j + len));
            }
            ans.add(row);
        }
        return ans;
    }

    private static ArrayList<ArrayList<Fraction>> matrixMinus(ArrayList<ArrayList<Fraction>> qMatrix, ArrayList<ArrayList<Fraction>> iMatrix) {
        int len = qMatrix.size();
        ArrayList<ArrayList<Fraction>> ans = new ArrayList<ArrayList<Fraction>>();
        for (int i = 0; i < len; i++) {
            ArrayList<Fraction> row = new ArrayList<Fraction>();
            for (int j = 0; j < len; j++) {
                row.add(iMatrix.get(i).get(j).minus(qMatrix.get(i).get(j)));
            }
            ans.add(row);
        }
        return ans;
    }

    private static ArrayList<ArrayList<Fraction>> getI(int size) {
        ArrayList<ArrayList<Fraction>> ans = new ArrayList<ArrayList<Fraction>>();
        Fraction one = new Fraction(1);
        Fraction zero = new Fraction(0);
        for (int i = 0; i < size; i++) {
            ArrayList<Fraction> row = new ArrayList<Fraction>();
            for (int j = 0; j < size; j++) {
                if (i == j){
                    row.add(one);
                }else {
                    row.add(zero);
                }
            }
            ans.add(row);
        }
        return ans;
    }

    private static ArrayList<ArrayList<Fraction>> getQ(ArrayList<ArrayList<Fraction>> nonTerminals) {
        ArrayList<ArrayList<Fraction>> ans = new ArrayList<ArrayList<Fraction>>();
        for (int i = 0; i < nonTerminals.size(); i++) {
            ArrayList<Fraction> QRow = new ArrayList<Fraction>();
            for (int j = 0; j < nonTerminals.size(); j++) {
                QRow.add(nonTerminals.get(i).get(j));
            }
            ans.add(QRow);
        }
        return ans;
    }


    public static class Fraction{
        private int numerator;
        private int denominator;

        public Fraction() {
            numerator = 0;
            denominator = 1;
        }

        public Fraction(int num) {
            numerator = num;
            denominator = 1;
        }

        public Fraction(int num, int denom) {
            this.numerator = num;
            if (denom == 0) {
                //system.out.println("Denominator cannot be 0. Setting it to 1");
            } else {
                this.denominator = denom;
            }
            this.reduce();
        }

        public void setNumerator(int num) {
            numerator = num;
            reduce();
        }

        public int getNumerator() {
            return numerator;
        }

        public void setDenominator(int denom) {
            if (denom > 0) {
                denominator = denom;
                reduce();
            }
            else if (denom < 0) {
                numerator = -numerator;
                denominator = -denom;
                reduce();
            }
        }

        public int getDenominator() {
            return denominator;
        }

        public Fraction addTo(Fraction rhs) {
            Fraction sum = new Fraction();
            sum.denominator = denominator * rhs.denominator;
            sum.numerator = numerator * rhs.denominator
                    + denominator * rhs.numerator;
            sum.reduce();
            return sum;
        }

        public Fraction minus(Fraction num){
            Fraction ans = new Fraction();
            ans.denominator = denominator * num.denominator;
            ans.numerator = numerator * num.denominator - denominator * num.numerator;
            ans.reduce();
            return ans;
        }

        public Fraction multiply(Fraction b){
            if ((denominator == 0) || (b.denominator == 0))
                throw new IllegalArgumentException("invalid denominator");
            Fraction ans = new Fraction();
            ans.numerator = numerator * b.numerator;
            ans.denominator = denominator * b.denominator;
            ans.reduce();
            return ans;
        }

        public Fraction divide(Fraction b){
            if ((denominator == 0) || (b.numerator == 0))
                throw new IllegalArgumentException("invalid denominator");
            Fraction result = new Fraction();
            result.numerator = numerator * b.denominator;
            result.denominator = denominator * b.numerator;
            result.reduce();
            return result;
        }

        public String toString() {
            return numerator + "/" + denominator;
        }

        public boolean equals(Fraction rhs) {
            return (numerator == rhs.numerator) && (denominator == rhs.denominator);
        }

        private void reduce() {
            // find the larger of the numerator and denominator
            int n = numerator, d = denominator, largest;
            if (numerator < 0) {
                n = -numerator;
            }
            if (n > d) {
                largest = n;
            }
            else {
                largest = d;
            }
            // find the largest number that divide the numerator and
            // denominator evenly
            int gcd = 0;
            for (int i = largest; i >= 2; i--) {
                if (numerator % i == 0 && denominator % i == 0) {
                    gcd = i;
                    break;
                }
            }
            // divide the largest common denominator out of numerator, denominator
            if (gcd != 0) {
                numerator /= gcd;
                denominator /= gcd;
            }
        }

        public static void main(String[] args) {
            Fraction f1 = new Fraction();   // local fraction objects
            Fraction f2 = new Fraction();   // used to test methods

            // one way to set up fractions is simply to hard-code some values
            f1.setNumerator(1);
            f1.setDenominator(3);
            f2.setNumerator(1);
            f2.setDenominator(6);

            // try some arithmetic on these fractions
            Fraction result = new Fraction();
            // test addition
            result = f1.addTo(f2);
            // one way to output results, using toString method directly
            System.out.println(f1 + " + " + f2 + " = " + result);
            // test addition going the other way - should be same result
            result = f2.addTo(f1);
            // output results
            System.out.println(f2 + " + " + f1 + " = " + result);
            System.out.println();

            // test subtraction
            result = f1.minus(f2);
            // output results
            System.out.println(f1 + " - " + f2 + " = " + result);
            // test subtraction going the other way - should be different result
            result = f2.minus(f1);
            // output results
            System.out.println(f2 + " - " + f1 + " = " + result);


            // test division
            result = f1.divide(f2);
            System.out.println(f1 + " / " + f2 + " = " + result);
        }
    }

    private static class Matrix {

        private final int M;
        private final int N;
        private final Fraction det;
        private ArrayList<ArrayList<Fraction>> matrix;
        private ArrayList<ArrayList<Fraction>> inverseMatrix;

        public Matrix(ArrayList<ArrayList<Fraction>> mat, int m, int n) {
            this.matrix = mat;
            this.M = m;
            this.N = n;
            this.det = this.determinant(mat, n);
            this.inverseMatrix = this.inverse();
        }

        private void getCofactor(ArrayList<ArrayList<Fraction>> mat, ArrayList<ArrayList<Fraction>> tempMat, int p, int q, int n) {
            int i = 0;
            int j = 0;
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    if (row != p && col != q) {
                        tempMat.get(i).set(j++, mat.get(row).get(col));
                        if (j == n - 1) {
                            j = 0;
                            i++;
                        }
                    }
                }
            }
        }

        private Fraction determinant(ArrayList<ArrayList<Fraction>> mat, int n) {
            Fraction ans = new Fraction(0, 1);
            if (this.M != this.N) {
                return ans;
            }
            if (n == 1) {
                return mat.get(0).get(0);
            }
            ArrayList<ArrayList<Fraction>> tempMat = new ArrayList<ArrayList<Fraction>>();
            // Init 2d fraction arraylist
            for (int i = 0; i < this.M; i++) {
                ArrayList<Fraction> tempMatRow = new ArrayList<Fraction>();
                for (int j = 0; j < this.N; j++) {
                    tempMatRow.add(new Fraction(0, 1));
                }
                tempMat.add(tempMatRow);
            }

            int sign = 1;
            Fraction signFraction = new Fraction(sign, 1);
            for (int k = 0; k < n; k++) {
                this.getCofactor(mat, tempMat, 0, k, n);
                ans = ans.addTo(signFraction.multiply(mat.get(0).get(k).multiply(determinant(tempMat, n - 1))));
                sign = -sign;
                signFraction = new Fraction(sign, 1);
            }
            return ans;
        }

        private void adjoint(ArrayList<ArrayList<Fraction>> mat, ArrayList<ArrayList<Fraction>> adj) {
            if (this.N == 1) {
                adj.get(0).set(0, new Fraction(1, 1));
                return;
            }
            int sign = 1;

            ArrayList<ArrayList<Fraction>> tempMat = new ArrayList<ArrayList<Fraction>>();
            // Init 2d fraction arraylist
            for (int i = 0; i < this.N; i++) {
                ArrayList<Fraction> tempMatRow = new ArrayList<Fraction>();
                for (int j = 0; j < this.N; j++) {
                    tempMatRow.add(new Fraction(0, 1));
                }
                tempMat.add(tempMatRow);
            }

            for (int p = 0; p < this.N; p++) {
                for (int q = 0; q < this.N; q++) {
                    this.getCofactor(mat, tempMat, p, q, this.N);
                    sign = ((p + q) % 2 == 0) ? 1 : -1;
                    Fraction signFraction = new Fraction(sign, 1);
                    adj.get(q).set(p, signFraction.multiply((this.determinant(tempMat, this.N - 1))));
                }
            }
        }

        private ArrayList<ArrayList<Fraction>> inverse() {
            ArrayList<ArrayList<Fraction>> inv = new ArrayList<ArrayList<Fraction>>();
            // Init 2d fraction arraylist
            for (int i = 0; i < this.M; i++) {
                ArrayList<Fraction> invRow = new ArrayList<Fraction>();
                for (int j = 0; j < this.N; j++) {
                    invRow.add(new Fraction(0, 1));
                }
                inv.add(invRow);
            }

            if (this.det.equals(new Fraction(0))) {
                return inv;
            }

            ArrayList<ArrayList<Fraction>> adj = new ArrayList<ArrayList<Fraction>>();
            // Init 2d fraction arraylist
            for (int i = 0; i < this.M; i++) {
                ArrayList<Fraction> adjRow = new ArrayList<Fraction>();
                for (int j = 0; j < this.N; j++) {
                    adjRow.add(new Fraction(0, 1));
                }
                adj.add(adjRow);
            }

            adjoint(this.matrix, adj);
            for (int p = 0; p < this.N; p++) {
                for (int q = 0; q < this.N; q++) {
                    Fraction temp = adj.get(p).get(q).divide(this.det);
                    inv.get(p).set(q, temp);
                }
            }
            return inv;
        }

        public Matrix getInverseMatrix() {
            if (this.M != this.N) {
                //system.out.println("No inverse matrix for non-square matrices");
            }
            return new Matrix(this.inverseMatrix, this.M, this.N);
        }

        public Fraction getElement(int m, int n) {
            return this.matrix.get(m).get(n);
        }

        public ArrayList<Fraction> getRow(int m) {
            if (m <= this.M) {
                return this.matrix.get(m);
            }
            return new ArrayList<Fraction>();
        }

        public Matrix plus(Matrix mat) {
            int M_m = mat.getDimension()[0];
            int N_m = mat.getDimension()[1];
            if (this.M != M_m || this.N != N_m) {
                //system.out.println("Error in plus: Dimensions of two matrices are not equal!"); // Debug
                return mat;
            } else {
                ArrayList<ArrayList<Fraction>> sum = new ArrayList<ArrayList<Fraction>>();
                // Init 2d fraction arraylist
                for (int i = 0; i < this.M; i++) {
                    ArrayList<Fraction> sumRow = new ArrayList<Fraction>();
                    for (int j = 0; j < this.N; j++) {
                        sumRow.add(new Fraction(0, 1));
                    }
                    sum.add(sumRow);
                }
                for (int i = 0; i < this.M; i++) {
                    for (int j = 0; j < this.N; j++) {
                        // sum[i][j] = this.matrix[i][j] + mat.getElement(i, j);
                        sum.get(i).set(j, this.matrix.get(i).get(j).addTo(mat.getElement(i, j)));
                    }
                }
                return new Matrix(sum, this.M, this.N);
            }
        }

        public Matrix minus(Matrix mat) {
            int M_m = mat.getDimension()[0];
            int N_m = mat.getDimension()[1];
            if (this.M != M_m || this.N != N_m) {
                //system.out.println("Error in minus: Dimensions of two matrices are not equal!"); // Debug
                return mat;
            } else {
                ArrayList<ArrayList<Fraction>> difference = new ArrayList<ArrayList<Fraction>>();
                // Init 2d fraction arraylist
                for (int i = 0; i < this.M; i++) {
                    ArrayList<Fraction> differenceRow = new ArrayList<Fraction>();
                    for (int j = 0; j < this.N; j++) {
                        differenceRow.add(new Fraction(0, 1));
                    }
                    difference.add(differenceRow);
                }
                for (int i = 0; i < this.M; i++) {
                    for (int j = 0; j < this.N; j++) {
                        // difference[i][j] = this.matrix[i][j] + mat.getElement(i, j);
                        difference.get(i).set(j, this.matrix.get(i).get(j).minus(mat.getElement(i, j)));
                    }
                }
                return new Matrix(difference, this.M, this.N);
            }
        }

        public Matrix multiply(Matrix mat) {
            // M N M N
            // X(m, n) x Y(n, p) = Z(m, p)
            int M_m = mat.getDimension()[0];
            int p_m = mat.getDimension()[1];
            if (this.N != M_m) {
                //system.out.println("Error in multiply: Dimensions of two matrices are valid for cross multiplication!"); // Debug
                return mat;
            } else {
                ArrayList<ArrayList<Fraction>> product = new ArrayList<ArrayList<Fraction>>();
                // Init 2d fraction arraylist
                for (int i = 0; i < this.M; i++) {
                    ArrayList<Fraction> productRow = new ArrayList<Fraction>();
                    for (int j = 0; j < p_m; j++) {
                        productRow.add(new Fraction(0, 1));
                    }
                    product.add(productRow);
                }
                for (int i = 0; i < this.M; i++) {
                    for (int j = 0; j < p_m; j++) {
                        for (int k = 0; k < this.N; k++) {
                            // product[i][j] += matrix[i][k] * mat.getElement(k, j);
                            Fraction temp = product.get(i).get(j);
                            product.get(i).set(j, temp.addTo(this.matrix.get(i).get(k).multiply(mat.getElement(k, j))));
                        }
                    }
                }
                return new Matrix(product, this.M, p_m);
            }

        }

        public int[] getDimension() {
            return new int[] { this.M, this.N };
        }
    }
}
