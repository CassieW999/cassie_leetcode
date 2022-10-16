import java.util.HashMap;
import java.util.Map;

public class longestWithoutRepeat {
    public static int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        while (right < s.length()){
            char c = s.charAt(right);
            if (map.containsKey(c)){
                left = map.get(c) + 1;
            }
            max = Math.max(max, right - left + 1);
            map.put(c, right++);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(lengthOfLongestSubstring(s));
    }

}
