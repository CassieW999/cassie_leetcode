public class convert {
    public static String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int groupNum = 2 * numRows - 2;
        if (n == 1 || numRows == 1 || n < numRows){
            return s;
        }
        int interval = groupNum;
        for (int i = 0; i < numRows; i++){
            int cur = i;
            sb.append(s.charAt(cur));
            while (cur < n){
                if (interval != 0 && interval != groupNum){
                    if (cur + interval < n){
                        cur += interval;
                        sb.append(s.charAt(cur));
                    }else{
                        break;
                    }
                    if (cur + groupNum - interval < n){
                        cur += groupNum - interval;
                        sb.append(s.charAt(cur));
                    }else{
                        break;
                    }
                }else{
                    if (cur + groupNum < n){
                        cur += groupNum;
                        sb.append(s.charAt(cur));
                    }else{
                        break;
                    }
                }
            }
            interval -= 2;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int num = 4;
        System.out.println(convert(s, num));
    }
}
