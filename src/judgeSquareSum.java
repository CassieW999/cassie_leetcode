public class judgeSquareSum {
    public boolean judgeSquareSum(int c) {
        int l = 0, r = (int)Math.sqrt(c);;
        while (l <= r){
            int res = l * l + r * r;
            if (res == c){
                return true;
            }if (res < c){
                l++;
            }else{
                r--;
            }
        }
        return false;
    }
}
