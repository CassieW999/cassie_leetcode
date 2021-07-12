//import java.util.Arrays;
//
//public class maximazeScore {
//    //
//    public static int maximazeScore(int[] nums){
//        int len = nums.length;
//        int n = len / 2;
//        int res = 0;
//        Arrays.sort(nums);
//        for (int i = n-1; i >= 0; i--) {
//            if (canFind(nums, i)){
//                res += i ;
//            }
//        }
//    }
//
//    private static boolean canFind(int[] nums, int i) {
//        return false;
//    }
//
//    public static int gcd(int x, int y){
//        if (y == 0) return x;
//        return gcd(y, x % y);
//    }
//}
