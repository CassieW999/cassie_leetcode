import java.util.Arrays;

public class eraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int cnt = 1;
        int end = intervals[0][1];
        for (int[] inter : intervals) {
            if (inter[0] >= end) {
                end = inter[1];
                ++cnt;
            }
        }
        return intervals.length - cnt;
    }
}
