import java.util.Map;
import java.util.Stack;

public class isValid2 {
    Map<Character, Character> match;
    public boolean isValid(String s) {
        match.put('(', ')');
        match.put('[', ']');
        match.put('{', '}');
        Stack<Character> q = new Stack<>();
        for (char c : s.toCharArray()){
            if (match.containsKey(c)){
                q.add(c);
            }else{
                if (q.isEmpty())return false;
                char top = q.peek();
                if (c == match.get(top)) {
                    q.pop();
                }else {
                    return false;
                }
            }
        }
        return q.isEmpty();
    }
}
