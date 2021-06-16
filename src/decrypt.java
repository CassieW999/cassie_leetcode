

public class decrypt {
    public static String decrypt(String word) {
        // your code goes here
        int n = word.length();
        int[] encryptNums = new int[word.length()];
        int[] decryptNums = new int[word.length()];

        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++){
            encryptNums[chars[i]] = 97 + (chars[i] - 'a');
        }

        decryptNums[0] = encryptNums[0] - 1;
        for (int i = 1; i < n; i++){
            int temp = encryptNums[i] - decryptNums[i-1];
            while (!(temp >= 97 && temp <= 122)){
                temp += 26;
            }
            decryptNums[i] = temp;
        }

        char[] newChars = new char[n];
        for (int i = 0; i < n; i++){
            newChars[i] = (char)(decryptNums[i] - 97);
        }
        return String.valueOf(newChars); // fixme
    }

    public static void main(String[] args) {
        String word = "dnotq";
        String ans = decrypt(word);
        System.out.println(ans);
    }
}
