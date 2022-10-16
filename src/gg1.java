import java.util.HashMap;
import java.util.Map;

public class gg1<main> {
    public static String gg1(String str){
        int len = str.length();
        int start = -1;
        int maxLen = 0;
        Map<Character, Integer> dic = new HashMap<>();
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (!dic.containsKey(c)){
                dic.put(c, i);
            }else{
                if (maxLen < i - dic.get(c)){//需要考虑如果有两个相同长度的应该如何处理
                    start = dic.get(c);
                    maxLen = i - dic.get(c);
                }
            }
        }
        return start == -1 ? "" : str.substring(start, start + maxLen + 1);
    }

    public static void main(String[] args) {
        String str = "abc";
        System.out.println(gg1(str));
    }
}
