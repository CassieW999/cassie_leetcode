import java.util.HashMap;

public class ValidAnagram {
    // public boolean isAnagram(String s, String t) {
    //     HashMap<Character,Integer> sMap = new HashMap();
    //     HashMap<Character,Integer> tMap = new HashMap();
    //     for(Character c : s.toCharArray()){
    //         sMap.put(c,sMap.getOrDefault(c,0)+1);
    //     }
    //     for(Character c : t.toCharArray()){
    //         tMap.put(c,tMap.getOrDefault(c,0)+1);
    //     }
    //     return sMap.equals(tMap);
    // }
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null) return true;
        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char sCur = s.charAt(i);
            char tCur = t.charAt(i);

            map.put(sCur, map.getOrDefault(sCur, 0) + 1);
            map.put(tCur, map.getOrDefault(tCur, 0) - 1);
            if(map.get(sCur) == 0) map.remove(sCur);
            if(map.containsKey(tCur) && map.get(tCur) == 0) map.remove(tCur);

        }

        return map.size() == 0;
    }
}
