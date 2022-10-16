import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class productQueries {
    public static int[] productQueries(int n, int[][] queries) {
        int mod = 1000000007;
        List<Integer> powers = getPowers(n);
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++){
            long cur = 1;
            int[] q = queries[i];
            for (int j = q[0]; j <= q[1]; j++){
                cur *= powers.get(j);
                cur %= mod;
            }
            ans[i] = (int) (cur % mod);
        }
        return ans;
    }

    // 20 --> 16 + 4
    // 15 --> 8 + 4 + 2 + 1
    public static List<Integer> getPowers(int n){
        List<Integer> ans = new ArrayList<>();
        for (int i = n; i >= 1; i--){
            if (i > n) continue;
            if ((i & (i-1)) == 0 ){
                ans.add(i);
                n -= i;
            }
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
//        int n = 15;
//        int[][] queries = {{0,1},{2,2},{0,3}};
        int n = 508; // 13 = 8 + 4 + 1
        int[][] queries = {{0, 6}};
        int[] ans = productQueries(n, queries);
        for (int x: ans)
            System.out.println(x);
    }
}
