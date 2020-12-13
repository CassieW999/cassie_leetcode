public class titleToNumber {
    public int titleToNumber(String s) {
        int sum=0;
        for(int i=s.length()-1;i>=0; i--){
            int k= (int)s.charAt(i) - 64;
            for(int j=0; j<s.length()-i-1; j++){
                k*=26;
            }
            sum+=k;
        }
        return sum;
    }
}
