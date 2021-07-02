import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class findAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        char ss[] = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> winmap = new HashMap<>();
        for(char c : p.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int l = 0;
        int r = 0;
        //记录有效字符个数
        int valid = 0;
        while(r < ss.length){
            char c = ss[r];
            r++;
            if(map.containsKey(c)){
                winmap.put(c,winmap.getOrDefault(c,0)+1);
                if(map.get(c).equals(winmap.get(c))){
                    valid++;
                }
            }
            //当窗口大小和s1大小一样时，判断是否包含然后再压缩左边界
            while(r-l == p.length()){
                if(valid == map.size()) {
                    list.add(l);
                }
                char d = ss[l];
                l++;
                if(map.containsKey(d)){
                    if(map.get(d).equals(winmap.get(d))){
                        valid--;
                    }
                    winmap.put(d,winmap.getOrDefault(d,0)-1);
                }
            }
        }
        return list;
    }
}
