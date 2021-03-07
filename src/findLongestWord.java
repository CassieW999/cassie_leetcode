import java.util.*;

public class findLongestWord {
    public String findLongestWord(String s, List<String> dictionary) {
        String ans = "";
        for (int i = 0; i < dictionary.size(); i++) {
            String dict = dictionary.get(i);
            int l = 0, r = 0;
            while (r < dict.length() && l < s.length()){
                if (s.charAt(l) == dict.charAt(r)){
                    l++;
                    r++;
                }else{
                    l++;
                }
            }
            if (r == dict.length()){
                if (dict.length() == ans.length()){
                    List<String> temp = Arrays.asList(dict, ans);
                    Collections.sort(temp);
                    ans = temp.get(0);
                }else {
                    ans = dict;
                }

            }
        }
        return ans;
    }
}
