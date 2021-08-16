public class addBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.valueOf(a) + Integer.valueOf(b)); // "12"
        for (int i = sb.length() - 1; i > 0; i--){
            int digit = Integer.valueOf(sb.charAt(i));
            int prev = Integer.valueOf(sb.charAt(i-1));
            char curChar = String.valueOf(digit % 2).charAt(0);
            char prevChar = String.valueOf(prev + digit / 2).charAt(0);
            sb.setCharAt(i-1, prevChar);
            sb.setCharAt(i, curChar);
        }
        if (sb.charAt(0) <= '1') return sb.toString();
        sb.reverse();
        char last = sb.charAt(sb.length() - 1);
        sb.setCharAt(sb.length() - 1, '1');
        sb.append('1');
        return sb.reverse().toString();
    }
}
