import java.util.*;

public class wordBreak2 {
    private static HashMap<String, List<String>> memo = new HashMap<>();

    public static List<String> wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0) {
            return Arrays.asList(new String[]{""});
        }

        if(memo.containsKey(s)) return memo.get(s);

        List<String> res = new ArrayList<>();

        for (String word : wordDict){
            if (s.startsWith(word)){
                String postfix = s.substring(word.length());
                for (String postfixs : wordBreak(postfix, wordDict)){
                    if (postfixs.length() == 0){
                        res.add(word);
                    }else {
                        res.add(word + " " + postfixs);
                    }
                }
            }
        }
        memo.put(s, res);
        return memo.get(s);
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> dict = Arrays.asList(new String[]{"cat", "cats", "and", "sand", "dog"});
        System.out.println(wordBreak(s, dict));
    }

//    public boolean wordBreak(String s, List<String> wordDict) {
//        if (s.length() == 0) return true;
//        StringBuilder sb = new StringBuilder();
//        int idx = 0;
//        while (!wordDict.contains(sb.toString()) && idx < s.length()){
//            sb.append(s.charAt(idx++));
//        }
//        if (idx == s.length()){
//            return wordDict.contains(sb.toString()) ? true : false;
//        }
//        return wordBreak(s.substring(idx), wordDict);
//    }
}
