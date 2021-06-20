import java.util.HashMap;

public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        if (n == 1)return 1;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(charArray[i])){
                left = Math.max(left, map.get(charArray[i]) + 1);
            }
            map.put(charArray[i], i);
        }
        return n - left + 1;
    }
}
