public class repeatedSubstringPattern {
    public static boolean repeatedSubstringPattern(String s) {
            return (s+s).indexOf(s,1) != s.length();
    }

    public static void main(String[] args) {
        String s = "abab";
        System.out.println(repeatedSubstringPattern(s));
    }
}
