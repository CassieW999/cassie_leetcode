public class characterReplacement {
    public int characterReplacement(String s, int k) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        if (len < 2) return len;
        int[] map = new int[26];
        int left = 0;
        int longestSingleCount = 0;
        for (int i = 0; i < len; i++) {
            map[charArray[i] - 'A']++;
            longestSingleCount = Math.max(longestSingleCount, map[charArray[i] - 'A']);
            if (i - left + 1 > longestSingleCount + k){
                map[charArray[left] - 'A']--;
                left++;
            }
        }
        return len - left;
    }
}
