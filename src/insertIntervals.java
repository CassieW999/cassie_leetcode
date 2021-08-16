import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class insertIntervals {
    List<List<Integer>> list;
    public int[][] insert(int[][] intervals, int[] newInterval) {
        list = new ArrayList<>();
        int start = intervals.length;
        int end = -1;
        for (int i = 0; i < intervals.length; i++){
            if (newInterval[0] > intervals[i][1] || newInterval[1] < intervals[i][0]){
                addToRes(intervals[i]);
            }else{
                start = getMin(start, newInterval[0], intervals[i][0]);
                end = getMax(end, newInterval[1], intervals[i][1]);
            }
        }
        if (start < end) addToRes(new int[]{start, end});
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++){
            res[i][0] = list.get(i).get(0);
            res[i][1] = list.get(i).get(1);
        }
        Arrays.sort(res, (int[] a, int[] b) -> (a[0] - b[0]));
        return res;
    }

    private int getMax(int a, int b, int c) {
        int max = Math.max(a, b);
        max = Math.max(max, c);
        return max;
    }

    private int getMin(int a, int b, int c) {
        int min = Math.min(a, b);
        min = Math.min(min, c);
        return min;
    }

    private void addToRes(int[] interval) {
        List<Integer> temp = new ArrayList<>();
        temp.add(interval[0]);
        temp.add(interval[1]);
        list.add(temp);
    }

}
