public class multiply2 {
    public static String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        String res = "";
        for (int i = n-1; i >= 0; i--){
            int cur = num2.charAt(i) - '0';
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < n - i - 1; k++){
                sb.append('0');
            }
            for (int j = m-1; j >= 0; j--){
                int curNum = num1.charAt(j) - '0';
                int curMulti = cur * curNum + carry;
                carry = curMulti / 10;
                sb.append(curMulti % 10);
            }
            if (carry != 0){
                sb.append(carry);
            }
            sb.reverse();
            res = addToRes(res, sb.toString());
        }
        return res;
    }

    public static String addToRes(String res, String add){
        int m = res.length(), n = add.length();
        int i = m -1, j = n-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0){
            int cur = carry;
            if (i >= 0) {
                cur += res.charAt(i) - '0';
                i--;
            }
            if (j >= 0){
                cur += add.charAt(j) - '0';
                j--;
            }
            carry = cur / 10;
            sb.append(cur % 10);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply(num1, num2));
    }
}
