import java.util.ArrayList;
import java.util.List;

public class fullJustify {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int curlinesum = 0;
        int i = 0;
        while (i < words.length){
            if (line.size() == 0 && words[i].length() == maxWidth){
                res.add(words[i]);
                i++;
            }else if (curlinesum + words[i].length() < maxWidth){
                // add it in the current line
                if (line.size() != 0) curlinesum += 1; // add an empty space
                line.add(words[i]);
                curlinesum += words[i].length();
                i++;
            }else {
                // start a next line
                int empty = maxWidth - curlinesum;
                StringBuilder sb = new StringBuilder();
                int len = line.size();
                for (int j = 0; j < len; j++){
                    if (j!= 0){
                        int cnt = 0;
                        while (cnt++ < (empty + len - j - 1) / (len - j) + 1)
                            sb.append(" ");
                        empty -= cnt - 2;
                    }
                    sb.append(line.get(j));
                }
                int slen = sb.length();
                int cnt = 0;
                while (cnt++ < maxWidth - slen){
                    sb.append(" ");
                }
                res.add(sb.toString());
                curlinesum = 0;
                line = new ArrayList<>();
            }
        }
        if (line.size() > 0){
            StringBuilder sb = new StringBuilder();
            int len = line.size();
            for (int m = 0; m < len; m++){
                if (m != 0) sb.append(" ");
                sb.append(line.get(m));
            }
            int cnt = 0;
            while (cnt++ < maxWidth - curlinesum){
                sb.append(" ");
            }
            res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"Listen","to","many,","speak","to","a","few."};
        int maxWidth = 6;
        System.out.println(fullJustify(words, maxWidth));
    }
}
