import java.util.HashMap;
import java.util.Map;

public class longestSubstring {
    public int longestSubstring(String s, int k) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }
        for (char c : map.keySet()){
            if (map.get(c) < k){
                int res = 0;
                String[] strs = s.split(String.valueOf(c));
                for (String str : strs){
                    res = Math.max(res, longestSubstring(str, k));
                }
                return res;
            }
        }
        return chars.length;
    }
}
