public class isSubsequence {
    public boolean isSubsequence(String s, String t) {
        int t_len= t.length();
        int s_len= s.length();
        if(s_len>t_len)
            return false;
        int charCounter = 0;
        for(int i=0;i<t_len;i++){
            if(charCounter==s_len){
                break;
            }
            if(t.charAt(i)==s.charAt(charCounter)){
                charCounter++;
            }else{
                continue;
            }
        }
        return charCounter==s_len;
    }
}
