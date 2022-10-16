import java.util.HashMap;
import java.util.Map;

public class longestRepeatingSubstringWithReplacement {
    public static int characterReplacement(String s, int k) {
        int left = 0, right = 0;
        int len = s.length();
        int max = 0;
        Map<Character, Integer> window = new HashMap<>();
        while (right < len){
            window.put(s.charAt(right), window.getOrDefault(right, 0) + 1);
            if (window.get(s.charAt(right)) >= right - left - k - 1){
                max = Math.max(max, right - left + 1);
            }else {
                left++;
            }
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "AAAA";
        int k = 2;
        System.out.println(characterReplacement(s, k));
    }
}
