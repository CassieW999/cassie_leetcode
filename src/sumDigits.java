public class sumDigits {
    public int sumDigits(int numX, int numY){
        int ans = 0;
        for (int i = 0; i <= numX; i++) {
            int s = 0;
            int x = i;
            while(x > 0){
                s += x % 10;
                x /= 10;
            }
            if (s == numY){
                ans++;
            }
        }
        return ans;
    }
}
