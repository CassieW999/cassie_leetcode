import java.util.*;

public class generateParenthesis {


    //////////////////////////////////////////          solution one         ////////////////////////////////////////////////////
    public List<String> generateParenthesis(int n) {
        if (n == 0) return null;
        List<String> ans = new ArrayList<>();
        helper(ans, "", 0, 0, n);

        return ans;
    }

    public void helper(List<String> ans, String curr, int open, int close, int max){
        if (curr.length() == max * 2){
            ans.add(curr);
            return;
        }

        if (open < max){
            helper(ans, curr + "(", open+1, close, max);
        }
        if (close < open){
            helper(ans, curr + ")", open, close + 1, max);
        }
    }

                        ///////////////        ANALYSIS FOR SOLUTION ONE         ///////////////////

    //该题的intuition solution来自于栈的理念，即栈底只能为闭括号，但是该题显然不能使用栈来解题，否则无法存储数据，因此，我们要做的是思考如何能够模拟栈的这种模式？
    //由此，我们想到可以采用计数的方式，只要维持开括号的数量永远大于等于闭括号的数量即可
    //另一个难点就在于实现回溯了，主动做这种题的数量还是少，导致刚做的时候知道要backtracing但是不知道如何下手，还是需要多练习
}
