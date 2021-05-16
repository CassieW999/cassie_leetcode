public class countBits {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; i++){
            int curr = 0;
            String binaryStr = Integer.toBinaryString(i);
            for (char a : binaryStr.toCharArray()){
                if (a == '1')
                    curr++;
            }
            ans[i] = curr;
        }
        return ans;
    }
}
