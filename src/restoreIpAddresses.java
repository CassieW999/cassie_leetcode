import java.util.ArrayList;
import java.util.List;

public class restoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();

        helper(s, res, 0, 4, "");
        return res;
    }

    private void helper(String s, List<String> res, int index, int remain, String curr){
        if(remain == 0){
            if(index == s.length()){
                res.add(curr);
            }

            return;
        }

        for(int i = 1; i <= 3; i++){
            if(index + i > s.length()) break;
            if(i != 1 && s.charAt(index) == '0' ) break;

            String temp = s.substring(index, index + i);
            int val = Integer.valueOf(temp);

            if(val <= 255){
                helper(s, res, index + i, remain - 1, curr + temp + (remain == 1 ? "" : "."));
            }
        }
    }
}
