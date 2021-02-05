import java.util.*;

public class reverseWords {
    public static String reverseWords(String s) {
        List<String> list = Arrays.asList(s.split(" "));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            StringBuilder sb = new StringBuilder(list.get(i));
            list.set(i, sb.reverse().toString());
        }

        return String.join(" ", list);
    }


    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
