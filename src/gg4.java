import java.util.HashMap;
import java.util.Map;

public class gg4 {
    static String res = "";
    static Map<String, String> map = new HashMap<>();
    public static String shortestSuperstring(String[] words) {
        for (String s : words){
            res += s;
        }
        boolean[] visited = new boolean[words.length];
        dfs(words, 0, new StringBuilder(), visited);
        return res;
    }

    public static void dfs(String[] words, int count, StringBuilder path, boolean[] visited){
        if (path.length() >= res.length()) return;
        if (count == words.length){
            res = res.length() > path.length() ? path.toString() : res;
            return;
        }
        for (int i = 0; i < words.length; i++){
            if (visited[i]) continue;
            StringBuilder temp = new StringBuilder(path);
            String joinStr = path + words[i];
            path = new StringBuilder(map.containsKey(joinStr) ? map.get(joinStr) : minMerge(path.toString(), words[i]));
            visited[i] = true;
            dfs(words, count + 1, path, visited);
            visited[i] = false;
            path = temp;
        }
    }

    public static String minMerge(String a, String b){
        int countAstart = helper(a, b);
        int countBstart = helper(b, a);
        if (countAstart >= countBstart){
            return a.substring(0, a.length() - countAstart) + b;
        }else{
            return b.substring(0, b.length() - countBstart) + a;
        }
    }

    public static int helper(String a, String b){
        for (int i = 0; i < a.length(); i++){
            if (b.startsWith(a.substring(i))){
                return a.length() - i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String a = "abcd";
        String b = "bce";
        System.out.println(shortestSuperstring(new String[]{a, b}));
    }
}
