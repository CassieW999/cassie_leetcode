

public class getMinimumJump {
    public static int getMinimumJump(int flagHeight, int bigJump){
        if (flagHeight < bigJump) return flagHeight;
        int[] dp = new int[flagHeight + 1];
        dp[bigJump] = 1;
        for (int i = 1; i < bigJump; i++){
            dp[i] = i;
        }
        for (int i = bigJump + 1; i <= flagHeight; i++){
            dp[i] = Math.min(dp[i - 1], dp[i - bigJump]) + 1;
        }
        return dp[flagHeight];
    }

    public static int addNumbers(float a, float b){
        float total = a + b;
        String str = total + "";
        System.out.println(str);
        String[] strArr = str.split(".");
        return Integer.valueOf(strArr[0]);
    }

    public static void main(String[] args) {
//        System.out.println(getMinimumJump(3, 1));
        System.out.println(addNumbers(2.3f, 1.9f));
//        String str = "4.2";
//        System.out.println(str.split("."));
    }
}
