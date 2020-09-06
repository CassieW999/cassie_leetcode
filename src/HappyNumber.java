import java.util.HashSet;

public class HappyNumber {
    public boolean isHappy(int n) {

        if(n < 1)  return false;

        HashSet<Integer> numbers = new HashSet<>();

        while(numbers.add(n)){
            int sum = 0;
            while(n > 0){
                int rem = n%10;
                sum += rem*rem;
                n /= 10;
            }
            if(sum == 1) return true;
            n = sum;
        }

        return false;
    }
}
