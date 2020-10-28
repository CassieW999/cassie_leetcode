import java.util.Arrays;

public class heightChecker {
    public int heightChecker(int[] heights) {
        int[] copy = heights.clone();
        Arrays.sort(copy);
        int index = 0;
        for (int i = 0; i < copy.length; i++) {
            if (heights[i] != copy[i]) index++;
        }
        return index;
    }
}
