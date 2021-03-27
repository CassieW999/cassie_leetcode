public class strStr {
    public static int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        if (m == 0 && n == 0) {
            return 0;
        }else if (n == 0){
            return 0;
        }else if (m == 0){
            return -1;
        }

        for (int i = 0; i <= m - n; i++){
            if (haystack.charAt(i) == needle.charAt(0)){
                String str = haystack.substring(i, i + n);
                if (str.equals(needle)) return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        if (1 == 1){

        }else if (2 == 2){

        }else {

        }

        for (int i = 0; i < 8; i++) {

        }

        System.out.println(strStr("hello", "ll"));
    }
}
