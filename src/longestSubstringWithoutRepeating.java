import java.util.HashSet;
import java.util.Set;

public class longestSubstringWithoutRepeating {
    public static int longestSubstringWithoutRepeating(String str){
        if (str == null || str.length() <= 1) return str.length();
        int n = str.length();
        int maxLen = 1;
        int len = 1;
        Set<Character> set = new HashSet<>();
        set.add(str.charAt(0));
        for (int i = 1; i < n; i++) {
            if (set.contains(str.charAt(i))){
                set.clear();
                maxLen = Math.max(maxLen, len);
                len = 0;
            }
            set.add(str.charAt(i));
            len++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "a";
        System.out.println(longestSubstringWithoutRepeating(str));
    }
}
