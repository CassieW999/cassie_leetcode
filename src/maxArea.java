import java.util.Arrays;

public class maxArea {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long maxX = 0, maxY = 0;
        int mod = 1000000007;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        for (int i = 0; i < horizontalCuts.length; i++){
            int len = i == 0 ? horizontalCuts[i] : horizontalCuts[i] - horizontalCuts[i-1];
            maxX = Math.max(maxX, len);
        }
        maxX = Math.max(maxX, h - horizontalCuts[horizontalCuts.length - 1]);
        for (int i = 0; i < verticalCuts.length; i++){
            int len = i == 0 ? verticalCuts[i] : verticalCuts[i] - verticalCuts[i-1];
            maxY = Math.max(maxY, len);
        }
        maxY = Math.max(maxY, w - verticalCuts[verticalCuts.length - 1]);
        return (int)((maxX * maxY) % mod);
    }

}
