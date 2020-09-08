import java.util.HashMap;
import java.util.HashSet;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character,String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        String[] arr = str.split(" ");

        if(pattern.length() != arr.length) return false;

        for(int i=0;i<arr.length;i++){
            char ch = pattern.charAt(i);
            if(map.containsKey(ch)){
                if(!map.get(ch).equals(arr[i])) return false;
            }else{
                if(set.contains(arr[i])) return false;
                set.add(arr[i]);
                map.put(ch, arr[i]);
            }
        }

        return true;
    }
}
