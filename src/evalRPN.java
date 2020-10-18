import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class evalRPN {

    public static int evalRPN(String[] tokens) {
        List<String> symbol = new ArrayList<>();
        symbol.add("+");
        symbol.add("-");
        symbol.add("*");
        symbol.add("/");

        Stack<Integer> s = new Stack<Integer>();
        for (String token : tokens){
            if (symbol.contains(token)){
                int n2 = s.pop();
                int n1 = s.pop();
                int n = 0;
                if (token.equals("+")) {
                    n = n1 + n2;
                }else if(token.equals("-")){
                    n = n1 - n2;
                }else if(token.equals("*")){
                    n = n1 * n2;
                }else{
                    n = n1 / n2;
                }
                s.push(n);
            }else{
                s.push(Integer.parseInt(token));
            }
        }
        return s.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens));
    }
}


////本题目是一道simulation的题，第一次做模拟题，代码难度以及逻辑难度都较低，但是找规律和找到模拟型是关键难点，
//解该题的关键在于理解题意，随后寻找合适的数据结构进行编译即可
