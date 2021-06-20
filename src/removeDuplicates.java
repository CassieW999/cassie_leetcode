import java.util.Stack;

public class removeDuplicates {
    public String removeDuplicates(String s) {
        //o(n)
        char[] list = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        int n = list.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            if (stack.isEmpty() || list[i] != stack.peek()){
                stack.push(list[i]);
                sb.append(list[i]);
            }else {
                stack.pop();
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }
}
