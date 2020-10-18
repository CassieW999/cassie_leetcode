public class hammingDistance {
    public int hammingDistance(int x, int y) {
        // int ans = 0;
        // for (int i = 0; i < 31; i++){
        //     int yi = y % 2;
        //     int xi = x % 2;
        //     if (xi != yi) ans++;
        //     y /= 2;
        //     x /= 2;
        // }
        // return ans;



        int num=x^y;
        int ans=0;
        while(num!=0)
        {
            ans++;
            num=num & (num-1);
        }
        return ans;
    }
}
