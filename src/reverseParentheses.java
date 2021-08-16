import java.util.Stack;

public class reverseParentheses {
    public String reverseParentheses(String s) {
        Stack<String> list = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '('){
                list.push(sb.toString());
                sb = new StringBuilder();
            }else if (c == ')'){
                sb.reverse();
                sb.insert(0, list.pop());
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
