public class minEatingSpeed {
    public int minEatingSpeed(int[] piles, int H) {
        int l = 1;
        int r = max(piles) + 1;
        while(l < r){
            int mid = l + (r - l) / 2;
            int h = 0;
            for (int p : piles){
                h += (p + mid - 1) / mid;
            }
            if (h <= H) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    public int max(int[] piles){
        int max = 0;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[0]);
        }
        return max;
    }
}
