public class powerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 2 == 1) return false;

        while (n != 2){
            if (n/2 % 2 == 0){
                n = n / 2;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(40));
        System.out.println(isPowerOfTwo(30));
        System.out.println(isPowerOfTwo(32));
        System.out.println(isPowerOfTwo(19));
        System.out.println(isPowerOfTwo(-2));
        System.out.println(isPowerOfTwo(88));

    }
}
