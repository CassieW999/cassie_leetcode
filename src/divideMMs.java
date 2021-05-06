public class divideMMs {
    public static int solutions(String s){
        int ans = 0;
        int len = s.length();
        if (len == 0) return ans;

        for (int j = 1; j < len; j++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(j));
            sb.append(s.substring(0, j));
            if (sb.toString().equals(s)) {
                ans = len / j;
                return ans;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        String s = "abccbaabccba";
        System.out.println(solutions(s));
    }
}
