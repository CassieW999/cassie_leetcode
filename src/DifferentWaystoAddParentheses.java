import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferentWaystoAddParentheses {

    public static List<Integer> diffWaysToCompute(String input) {
        Map<String, List<Integer>> memo = new HashMap<>();
        if (memo.containsKey(input)) return memo.get(input);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); ++i) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int j = 0; j < left.size(); ++j) {
                    for (int k = 0; k < right.size(); ++k) {
                        if (c == '+') {
                            res.add(left.get(j) + right.get(k));
                        } else if (c == '-') {
                            res.add(left.get(j) - right.get(k));
                        } else {
                            res.add(left.get(j) * right.get(k));
                        }
                    }
                }
            }
        }
        if (input.matches("[0-9]+")) {//正则表达式
            res.add(Integer.valueOf(input));
        }
        return res;
    }

    public static void main(String[] args) {
        String input = "2*3-4*5";
        List<Integer> list = diffWaysToCompute(input);
        System.out.println(list);
    }
}
