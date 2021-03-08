import java.util.*;

public class isHappy {
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int curr = n;
        while (!set.contains(curr)){
            int num = 0;
            String currStr = String.valueOf(curr);
            for (int i = 0; i < currStr.length(); i++) {
                num += Character.getNumericValue(currStr.charAt(i)) * Character.getNumericValue(currStr.charAt(i));
            }
            if (num == 1) return true;
            set.add(curr);
            curr = num;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean ans = isHappy(19);
        System.out.println(ans);
    }
}
