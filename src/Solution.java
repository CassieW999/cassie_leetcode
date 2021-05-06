import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private static class Fraction {
        private int numerator = 0;
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

        private int getGCM(int a, int b) {
            if (b == 0)
                return a;
            return getGCM(b, a%b);
        }

        public void simplify() {
            this.sign = !(this.numerator <= 0 && this.denominator <= 0) && !(this.numerator >= 0 && this.denominator >= 0);

            this.numerator = Math.abs(this.numerator);
            this.denominator = Math.abs(this.denominator);

            int gcm = this.getGCM(this.numerator, this.denominator);
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
                } else {
                    num = (-1) * this.numerator * f1.denominator + this.denominator * f1.numerator;
                }
            } else {
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
            if (this.sign && !f1.getSign() || !this.sign && f1.getSign()) {
                signInt = -1;
            }
            return new Fraction(signInt * this.numerator * f1.getNumerator(), this.denominator * f1.getDenominator());
        }

        public Fraction dividedBy(Fraction f1) {
            int signInt = 1;
            if (this.sign && !f1.getSign() || !this.sign && f1.getSign()) {
                signInt = -1;
            }
            return new Fraction(signInt *this.numerator * f1.getDenominator(), this.denominator * f1.getNumerator());
        }

        public boolean equals(Fraction f1) {
            return this.numerator == f1.getNumerator() && this.denominator == f1.getDenominator() && this.sign == f1.getSign();
        }

        public int getNumerator() {
            return this.numerator;
        }

        public int getDenominator() {
            return this.denominator;
        }

        public boolean getSign() {
            return this.sign;
        }

        public String toString() {
            String signStr = "";
            String fractionStr = "";
            if (this.sign) {
                signStr = "-";
            }
            if (numerator == denominator) {
                fractionStr = "1";
            } else if (denominator == 1) {
                fractionStr = Integer.toString(numerator);
            } else {
                fractionStr = numerator + "/" + denominator;
            }
            return signStr + fractionStr;
        }
    }

    public static void main(String[] args) {
        int[][] m = {{0, 1, 0, 0, 0, 1}, {4, 0, 0, 3, 2, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};
        int[] ans = solutionFuel(m);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    public static int[] solutionFuel(int[][] m) {
        if (m.length == 0)return new int[0];
        if (m.length == 1){
            return new int[]{1, 1};
        }
        int len = m.length;
        double[][] mDouble = new double[len][len];
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = 0; j < len; j++) {
                sum += m[i][j];
            }
            if (i == 0 && sum == 0){
                int[] ans_zero = new int[len + 1];
                ans_zero[0] = 1;
                ans_zero[len] = 1;
                return ans_zero;
            }
            for (int j = 0; j < len; j++) {
                if (sum != 0){
                    mDouble[i][j] = (double)m[i][j] / sum;
                }
            }
        }

        ArrayList<double[]> transientState = new ArrayList<double[]>();
        ArrayList<double[]> absorbState = new ArrayList<double[]>();
        for (int i = 0; i < len; i++) {
            boolean isTransient = false;
            for (int j = 0; j < len; j++) {
                if (mDouble[i][j] != 0){
                    isTransient = true;
                }
            }

            if (isTransient){
                transientState.add(mDouble[i]);
            }else {
                absorbState.add(mDouble[i]);
            }
        }

        double[][] transients = convertArraylistToArrays(transientState, len);
        double[][] absorb = convertArraylistToArrays(absorbState, len);

        double[][] Q = getQ(transients);
        double[][] I = getI(Q.length);
        double[][] QMinusI = matrixMinus(Q, I);
        double[][] reversedQMinusI = reverseMatrix(QMinusI);
        double[][] R = getR(transients, len);
        double[][] multi = multiplyMatrix(reversedQMinusI, R);
        double[] ans_raw = multi[0];
        int[] ans = doubleToInt(ans_raw);
        return ans;
    }

    public static double[][] multiplyMatrix(double[][] firstMatrix, double[][] secondMatrix) {
        int r1 = firstMatrix.length;
        int c1 = firstMatrix[0].length;
        int c2 = secondMatrix[0].length;
        double[][] product = new double[r1][c2];
        for(int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    product[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }
        return product;
    }

    public static int[] doubleToInt(double[] ans_raw) {
        int[] ans = new int[ans_raw.length + 1];
        int[] upNums = new int[ans_raw.length];
        int[] downNums = new int[ans_raw.length];

        for (int i = 0; i < ans_raw.length; i++) {
            upNums[i] = (int)(convertDecimalToFraction(ans_raw[i])[0]);
            downNums[i] = (int)(convertDecimalToFraction(ans_raw[i])[1]);
        }

        int lcm = findLCM(downNums);
        for (int i = 0; i < ans_raw.length; i++) {
            ans[i] = upNums[i] * (lcm / convertDecimalToFraction(ans_raw[i])[1]);
        }
        ans[ans.length - 1] = lcm;
        return ans;
    }

    public static int findLCM(int[] nums) {
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

    public static int[] convertDecimalToFraction(double x) {
        double tolerance = 1.0E-10;
        double h1=1; double h2=0;
        double k1=0; double k2=1;
        double b = x;
        do {
            double a = Math.floor(b);
            double aux = h1; h1 = a*h1+h2; h2 = aux;
            aux = k1; k1 = a*k1+k2; k2 = aux;
            b = 1/(b-a);
        } while (Math.abs(x-h1/k1) > x*tolerance);

        return new int[]{(int)h1, (int)k1};
    }

    public static double[][] getR(double[][] transients, int size) {
        int len = transients.length;
        double[][] ans = new double[len][size - len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < size - len; j++) {
                ans[i][j] = transients[i][j + len];
            }
        }
        return ans;
    }

    public static double[][] reverseMatrix(double[][] a) {
        int n = a.length;
        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        int index[] = new int[n];
        for (int i=0; i<n; ++i)
            b[i][i] = 1;

        gaussian(a, index);

        for (int i=0; i<n-1; ++i)
            for (int j=i+1; j<n; ++j)
                for (int k=0; k<n; ++k)
                    b[index[j]][k]
                            -= a[index[j]][i]*b[index[i]][k];

        for (int i=0; i<n; ++i)
        {
            x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
            for (int j=n-2; j>=0; --j)
            {
                x[j][i] = b[index[j]][i];
                for (int k=j+1; k<n; ++k)
                {
                    x[j][i] -= a[index[j]][k]*x[k][i];
                }
                x[j][i] /= a[index[j]][j];
            }
        }
        return x;
    }

    public static void gaussian(double a[][], int index[]) {
        int n = index.length;
        double c[] = new double[n];

        for (int i=0; i<n; ++i)
            index[i] = i;

        for (int i=0; i<n; ++i) {
            double c1 = 0;
            for (int j=0; j<n; ++j) {
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }

        int k = 0;
        for (int j=0; j<n-1; ++j) {
            double pi1 = 0;
            for (int i=j; i<n; ++i) {
                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1) {
                    pi1 = pi0;
                    k = i;
                }
            }
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i=j+1; i<n; ++i) {
                double pj = a[index[i]][j]/a[index[j]][j];

                a[index[i]][j] = pj;

                for (int l=j+1; l<n; ++l)
                    a[index[i]][l] -= pj*a[index[j]][l];
            }
        }
    }

    public static double[][] matrixMinus(double[][] q, double[][] i) {
        int len = q.length;
        double[][] ans = new double[len][len];
        for (int j = 0; j < len; j++) {
            for (int k = 0; k < len; k++) {
                ans[j][k] = i[j][k] - q[j][k];
            }
        }
        return ans;
    }

    public static double[][] getI(int length) {
        double[][] ans = new double[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j){
                    ans[i][j] = 1;
                }else {
                    ans[i][j] = 0;
                }
            }
        }
        return ans;
    }

    public static double[][] getQ(double[][] transients) {
        int len = transients.length;
        double[][] ans = new double[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                ans[i][j] = transients[i][j];
            }
        }
        return ans;
    }

    public static double[][] convertArraylistToArrays(ArrayList<double[]> list, int len){
        double[][] ans = new double[list.size()][len];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }


    //===================================================
    public static int solution1(int src, int dest) {
        if (src == dest) return 0;
        int shortest_path = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[64];
        q.add(src);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                visited[curr] = true;
                if (curr == dest) return shortest_path;
                updateQueue(q, curr, visited);
            }
            shortest_path++;
        }
        return -1;
    }

    private static void updateQueue(Queue<Integer> q, int curr, boolean[] visited) {
        int row = curr / 8;
        int col = curr % 8;
        int[][] directions = {{-1, -2}, {-2, -1}, {-1, 2}, {1, -2}, {2, -1}, {-2, 1}, {1, 2}, {2, 1}};
        for (int i = 0; i < 8; i++) {
            int new_row = row + directions[i][0];
            int new_col = col + directions[i][1];
            int new_num = 8 * new_row + new_col;
            if (new_row >= 0 && new_row <= 7 && new_col >= 0 && new_col <= 7 && new_num >= 0 && new_num <= 63 && !visited[new_num]){
                q.add(new_num);
                visited[new_num] = true;
            }
        }
    }

    public static int solution(int src, int dest) {

        // if the knight is already at the destination
        if (src == dest){
            return 0;
        }

        int shortest_path_distance = -1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        queue.add(-100);
        boolean[] visited_or_not = new boolean[64];
        boolean found;

        for (int i = 0; i < 64; i++) {
            visited_or_not[i] = false;
        }

        int path_dist = 1;


        while (!queue.isEmpty()) {
            int val = queue.remove();
            if (val == -100) {
                path_dist++;
                val = queue.remove();
                queue.add(-100);
            }

            found = update_queue(queue, val, dest, visited_or_not);

            if (found) {
                return path_dist;
            }


        }


        return shortest_path_distance;
    }


    public static boolean update_queue(Queue<Integer> queue, int val, int dest, boolean[] visited_or_not) {
        int check_val = -1;
        boolean found = false;
        switch (val % 8) {
            // if case '0', the current node is in the first column
            case 0:

                // do not check the following as they have to go left and hence will go out of bounds
                // do not check up two and left one(-17)
                // do not check down two and left one(+15)
                // do not check left two and up one(-10)
                // do not check left two and down one(+6)


                // check for values up two spaces and right one space
                check_val = val - 15;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }

                // check for values right two spaces and up one space
                check_val = val - 6;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }

                // check for values right two spaces and down one space
                check_val = val + 10;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }


                // check for values down two spaces and right one space
                check_val = val + 17;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }

                break;

            // if case '1', the current node is in the second column
            case 1:

                // do not check the following as they have to two left and hence will go out of bounds
                // do not check left two and up one(-10)
                // do not check left two and down one(+6)


                // check for values up two spaces and right one space
                check_val = val - 15;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }

                // check for values right two spaces and up one space
                check_val = val - 6;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }

                // check for values right two spaces and down one space
                check_val = val + 10;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }


                // check for values down two spaces and right one space
                check_val = val + 17;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }

                // check for values down two spaces and left one space
                check_val = val + 15;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }

                // check for values up two spaces and left one space
                check_val = val - 17;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }

                break;


            // if case '6', the current node is in the second last column
            case 6:

                // do not check the following as they have to two right and hence will go out of bounds
                // do not check right two and up one(-6)
                // do not check right two and down one(+10)


                // check for values left two spaces and up one space
                check_val = val - 10;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }

                // check for values up two spaces and left one space
                check_val = val - 17;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }

                // check for values down two spaces and left one space
                check_val = val + 15;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }


                // check for values left two spaces and down one space
                check_val = val + 6;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }

                // check for values up two spaces and right one space
                check_val = val - 15;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }

                // check for values down two spaces and right one space
                check_val = val + 17;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }

                break;


            // if case '7', the current node is in the last column
            case 7:

                // do not check the following as they have to go right and hence will go out of bounds
                // do not check up two and right one(-15)
                // do not check down two and left one(+17)
                // do not check right two and up one(-6)
                // do not check right two and down one(+10)


                // check for values left two spaces and up one space
                check_val = val - 10;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }

                // check for values up two spaces and left one space
                check_val = val - 17;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }

                // check for values right two spaces and down one space
                check_val = val + 15;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }


                // check for values left two spaces and down one space
                check_val = val + 6;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }

                break;


            // of we reach this level, we are in the center, and can find all 8 possible destination points
            default:


                /*
                Use symmetry of chess board to group possible places knight can be at
                 */

                ///////////////////////////   17   ///////////////////////////
                // check for values up two spaces and left one space
                check_val = val - 17;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }


                // check for values down two spaces and right one space
                check_val = val + 17;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }
                ///////////////////////////   17   ///////////////////////////




                ///////////////////////////   15   ///////////////////////////
                // check for values up two spaces and left one space
                check_val = val - 15;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }


                // check for values down two spaces and right one space
                check_val = val + 15;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }
                ///////////////////////////   15   ///////////////////////////


                ///////////////////////////   6   ///////////////////////////
                // check for values up two spaces and left one space
                check_val = val - 6;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }


                // check for values down two spaces and right one space
                check_val = val + 6;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }
                ///////////////////////////   6   ///////////////////////////



                ///////////////////////////   10   ///////////////////////////
                // check for values up two spaces and left one space
                check_val = val - 10;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }


                // check for values down two spaces and right one space
                check_val = val + 10;
                found = check_and_add(queue, check_val, dest, visited_or_not);
                if (found) {
                    return true;
                }
                ///////////////////////////   10   ///////////////////////////

        }
        return false;
    }


    public static boolean check_and_add(Queue<Integer> queue, int check_val, int dest, boolean[] visited_or_not) {
        if (check_val >= 0 && check_val <= 63 && !visited_or_not[check_val]) {


            if (check_val == dest) {
                return true;
            }
            visited_or_not[check_val] = true;
            queue.add(check_val);


        }
        return false;
    }
}