import java.lang.Math;
import java.util.ArrayList;
public class Solutions {
    public static void main(String[] args) {
        int[][] m = {{0, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 0, 0},{4, 0, 0, 3, 2, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};
        int[] ans = solution(m);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    public static int[] solution(int[][] m) {
        // Your code here
        ArrayList<Integer> terminalList = new ArrayList<Integer>();
        ArrayList<Integer> nonTermList = new ArrayList<Integer>();
        ArrayList<Integer> denominatorList = new ArrayList<Integer>();
        if(m.length < 2) {
            return new int[]{1, 1};
        }
        for (int i = 0; i < m.length; i++) {
            boolean isTerminal = true;
            int sum = 0;
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] != 0) {
                    isTerminal = false;
                    sum += m[i][j];
                }
            }
            if (isTerminal){
                terminalList.add(i);
            }
            else{
                nonTermList.add(i);
                denominatorList.add(sum);
            }
        }
        Matrix I = getI(nonTermList.size());
        Matrix Q = getQ(nonTermList, denominatorList, m);
        Matrix R = getR(nonTermList, terminalList, denominatorList, m);
        Matrix IminusQ = I.minus(Q);
        Matrix F = IminusQ.getInverseMatrix();
        Matrix FR = F.multiply(R);
        ArrayList<Fraction> ans_raw = FR.getRow(0);
        int[] ans = findFinalAns(ans_raw);
        return ans;
    }

    private static int[] findFinalAns(ArrayList<Fraction> num) {
        int[] res = new int[num.size()+1];
        int[] numeratorList = new int[num.size()];
        int[] denomList = new int[num.size()];
        for (int i = 0; i < num.size(); i++) {
            denomList[i] = num.get(i).getDenominator();
            numeratorList[i] = num.get(i).getNumerator();
        }
        int lcm = getLcm(denomList);
        for (int i = 0; i < num.size(); i++) {
            denomList[i] = num.get(i).getDenominator();
        }
        for (int j = 0; j < res.length-1; j++) {
            res[j] = numeratorList[j] * (lcm / denomList[j]);
        }
        res[num.size()] = lcm;
        return res;
    }

    private static Matrix getR(ArrayList<Integer> nonTermList, ArrayList<Integer> terminalList, ArrayList<Integer> denominatorList, int[][] m) {
        ArrayList<ArrayList<Fraction>> ans = new ArrayList<ArrayList<Fraction>>();
        for (int i = 0; i < nonTermList.size(); i++) {
            ArrayList<Fraction> row = new ArrayList<Fraction>();
            for (int j = 0; j < terminalList.size(); j++) {
                row.add(new Fraction(m[nonTermList.get(i)][terminalList.get(j)], denominatorList.get(i)));
            }
            ans.add(row);
        }
        return new Matrix(ans, nonTermList.size(), terminalList.size());
    }

    private static Matrix getQ(ArrayList<Integer> nonTermList, ArrayList<Integer> denominatorList, int[][] m) {
        ArrayList<ArrayList<Fraction>> ans = new ArrayList<ArrayList<Fraction>>();
        for (int i = 0; i < nonTermList.size(); i++) {
            ArrayList<Fraction> row = new ArrayList<Fraction>();
            for (int j = 0; j < nonTermList.size(); j++){
                row.add(new Fraction(m[nonTermList.get(i)][nonTermList.get(j)], denominatorList.get(i)));
            }
            ans.add(row);
        }

        return new Matrix(ans, nonTermList.size(), nonTermList.size());
    }

    private static Matrix getI(int size) {
        Fraction one = new Fraction(1);
        Fraction zero = new Fraction(0);
        ArrayList<ArrayList<Fraction>> ans = new ArrayList<ArrayList<Fraction>>();
        for (int i = 0; i < size; i++) {
            ArrayList<Fraction> row = new ArrayList<Fraction>();
            for (int j = 0; j < size; j++){
                if (i == j){
                    row.add(one);
                } else{
                    row.add(zero);
                }
            }
            ans.add(row);
        }
        return new Matrix(ans, size,size);
    }

    public static int getLcm(int nums[]){
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

    public static class Fraction {
        private int numerator;
        private int denominator = 1;
        private boolean sign = false;

        public Fraction(int num, int denom) {
            this.numerator = num;
            if (denom == 0) {
            } else {
                this.denominator = denom;
            }
            this.simplify();
        }

        public Fraction(int num) {
            this.numerator = num;
            this.simplify();
        }

        private int getGcm(int num1, int num2) {
            return num2 == 0 ? num1 : this.getGcm(num2, num1 % num2);
        }

        public void simplify() {
            this.sign = !(this.numerator <= 0 && this.denominator <= 0) && !(this.numerator >= 0 && this.denominator >= 0);

            this.numerator = Math.abs(this.numerator);
            this.denominator = Math.abs(this.denominator);

            int gcm = this.getGcm(this.numerator, this.denominator);
            this.numerator = this.numerator / gcm;
            this.denominator = this.denominator / gcm;
            if (this.numerator == 0 && this.denominator != 0) {
                this.denominator = 1;
                this.sign = false;
            }
        }

        public Fraction plus(Fraction f1) {
            int num = 0;
            if (this.sign) {
                if (f1.getSign()) {
                    num = (-1) * this.numerator * f1.denominator + this.denominator * (-1) * f1.numerator;
                } else { // f1 is positive
                    num = (-1) * this.numerator * f1.denominator + this.denominator * f1.numerator;
                }
            } else { // this fraction is positive
                if (f1.getSign()) { // f1 is negative
                    num = this.numerator * f1.denominator + this.denominator * (-1) * f1.numerator;
                } else { // f1 is positive
                    num = this.numerator * f1.denominator + this.denominator * f1.numerator;
                }
            }
            int denom = this.denominator * f1.getDenominator();
            return new Fraction(num, denom);
        }

        public Fraction minus(Fraction f1) {
            int num = 0;
            if (this.sign) { // this fraction is negative
                if (f1.getSign()) { // f1 is negative
                    num = (-1) * this.numerator * f1.denominator + this.denominator * f1.numerator;
                } else { // f1 is positive
                    num = (-1) * this.numerator * f1.denominator - this.denominator * f1.numerator;
                }
            } else { // this fraction is positive
                if (f1.getSign()) { // f1 is negative
                    num = this.numerator * f1.denominator + this.denominator * f1.numerator;
                } else { // f1 is positive
                    num = this.numerator * f1.denominator - this.denominator * f1.numerator;
                }
            }
            int denom = this.denominator * f1.getDenominator();
            return new Fraction(num, denom);
        }

        public Fraction multiply(Fraction f1) {
            int signInt = 1;
            // Either one fraction is negative will make the product fraction negative, but not for both fractions are negative.
            if (this.sign && !f1.getSign() || !this.sign && f1.getSign()) {
                signInt = -1;
            }
            return new Fraction(signInt * this.numerator * f1.getNumerator(), this.denominator * f1.getDenominator());
        }

        public Fraction dividedBy(Fraction f1) {
            int signInt = 1;
            // Either one fraction is negative will make the product fraction negative, but not for both fractions are negative.
            if (this.sign && !f1.getSign() || !this.sign && f1.getSign()) {
                signInt = -1;
            }
            return new Fraction(signInt *this.numerator * f1.getDenominator(), this.denominator * f1.getNumerator());
        }

        public boolean equals(Fraction f1) {
            return this.numerator == f1.getNumerator() && this.denominator == f1.getDenominator() && this.sign == f1.getSign();
        }

        public int getNumerator()
        {
            return this.numerator;
        }

        public int getDenominator() {
            return this.denominator;
        }

        public boolean getSign()
        {
            return this.sign;
        }

        public String toString()
        {
            String signStr = "";
            String fractionStr = "";
            if (this.sign)
            {
                signStr = "-";
            }
            if (numerator == denominator)
            {
                fractionStr = "1";
            }
            else if (denominator == 1)
            {
                fractionStr = Integer.toString(numerator);
            }
            else
            {
                fractionStr = numerator + "/" + denominator;
            }
            return signStr + fractionStr;
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
                ans = ans.plus(signFraction.multiply(mat.get(0).get(k).multiply(determinant(tempMat, n - 1))));
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
                    Fraction temp = adj.get(p).get(q).dividedBy(this.det);
                    inv.get(p).set(q, temp);
                }
            }
            return inv;
        }

        public Matrix getInverseMatrix() {
            if (this.M != this.N) {
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
                return mat;
            } else {
                ArrayList<ArrayList<Fraction>> sum = new ArrayList<ArrayList<Fraction>>();
                for (int i = 0; i < this.M; i++) {
                    ArrayList<Fraction> sumRow = new ArrayList<Fraction>();
                    for (int j = 0; j < this.N; j++) {
                        sumRow.add(new Fraction(0, 1));
                    }
                    sum.add(sumRow);
                }
                for (int i = 0; i < this.M; i++) {
                    for (int j = 0; j < this.N; j++) {
                        sum.get(i).set(j, this.matrix.get(i).get(j).plus(mat.getElement(i, j)));
                    }
                }
                return new Matrix(sum, this.M, this.N);
            }
        }

        public Matrix minus(Matrix mat) {
            int M_m = mat.getDimension()[0];
            int N_m = mat.getDimension()[1];
            if (this.M != M_m || this.N != N_m) {
                return mat;
            } else {
                ArrayList<ArrayList<Fraction>> difference = new ArrayList<ArrayList<Fraction>>();
                for (int i = 0; i < this.M; i++) {
                    ArrayList<Fraction> differenceRow = new ArrayList<Fraction>();
                    for (int j = 0; j < this.N; j++) {
                        differenceRow.add(new Fraction(0, 1));
                    }
                    difference.add(differenceRow);
                }
                for (int i = 0; i < this.M; i++) {
                    for (int j = 0; j < this.N; j++) {
                        difference.get(i).set(j, this.matrix.get(i).get(j).minus(mat.getElement(i, j)));
                    }
                }
                return new Matrix(difference, this.M, this.N);
            }
        }

        public Matrix multiply(Matrix mat) {
            int M_m = mat.getDimension()[0];
            int p_m = mat.getDimension()[1];
            if (this.N != M_m) {
                return mat;
            } else {
                ArrayList<ArrayList<Fraction>> product = new ArrayList<ArrayList<Fraction>>();
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
                            Fraction temp = product.get(i).get(j);
                            product.get(i).set(j, temp.plus(this.matrix.get(i).get(k).multiply(mat.getElement(k, j))));
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