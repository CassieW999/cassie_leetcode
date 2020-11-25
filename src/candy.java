import java.util.Arrays;

public class candy {
    public int candy(int[] ratings) {
        int size = ratings.length;
        if (size < 2) return size;

        int[] candies = new int[size];

        Arrays.fill(candies, 1);

        for (int i = 1; i < size; i++){
            if (ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1] + 1;
            }
        }
        int sum = candies[ratings.length - 1];
        for (int i = size - 2; i >= 0; i--){
            if (ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i], candies[i+1]+1);
            }
            sum += candies[i];
        }
        return sum;
    }
}
