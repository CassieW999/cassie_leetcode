public class myAtoi2 {
    public static int myAtoi(String s) {
        s = s.replace(" ", "");
        int multiply = 1;
        int begin = 0;
        int res = 0;
        if (s.charAt(0) == '-' || s.charAt(0) == '+'){
            multiply = s.charAt(0) == '-' ? -1 : 1;
            begin = 1;
        }
        for (int i = begin; i < s.length(); i++){
            if (Character.isDigit(s.charAt(i))){
                res = res * 10 + (s.charAt(i) - '0');
                if (multiply == 1 && res > Integer.MAX_VALUE / 10){
                    System.out.println("====");
                    return Integer.MAX_VALUE;
                }
                if (multiply == -1 && res > Integer.MAX_VALUE / 10){
                    System.out.println("----");
                    return Integer.MIN_VALUE;
                }
            }else{
                break;
            }
        }
        return res * multiply;
    }

    public static void main(String[] args) {
        String s = "   +0 123";
        System.out.println(myAtoi(s));
    }
}
