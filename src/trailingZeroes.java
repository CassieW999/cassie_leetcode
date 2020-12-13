public class trailingZeroes {
    public int trailingZeroes(int n) {
        int zeros = 0;
        while(n > 1){
            n = n / 5;
            zeros += n;
        }
        return zeros;
    }
}
