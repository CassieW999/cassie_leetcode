import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
//         char[] map = new char[256];
//         char[] set = new char[256];

//         for(int i=0;i<s.length();i++){
//             char ch1 = s.charAt(i);
//             char ch2 = t.charAt(i);

//             if(map[ch1]!=0){
//                 if(ch2 != map[ch1]) return false;
//             }else{
//                 if(set[ch2]!=0) return false; // already mapped
//                 map[ch1] = ch2;
//                 set[ch2] = ch2; // This char is now mapped so can't be remapped
//             }
//         }

//         return true;
        Map<Character,Character> map = new HashMap();
        if(s.length() != t.length()){
            return false;
        }
        Set<Character> set = new HashSet();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i)) != (t.charAt(i))){
                    return false;
                }
            }else{
                if(set.contains(t.charAt(i))){
                    return false;
                }
                set.add(t.charAt(i));
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}
