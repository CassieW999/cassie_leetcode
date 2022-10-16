public class almostEqualNumber {
    public static int almostEqualNumber(int[] nums){
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++) {
                String strA = nums[i] + "";
                String strB = nums[j] + "";
                if (strA.length() != strB.length() || strA.equals(strB)) continue;
                if (checkAlmostEqual(strA, strB)){
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean checkAlmostEqual(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++){
            if (a.charAt(i) != b.charAt(i)) diff++;
        }
        return diff == 1;
    }

}
