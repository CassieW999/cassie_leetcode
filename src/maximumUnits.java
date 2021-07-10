import java.util.Arrays;
import java.util.Comparator;

public class maximumUnits {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });
        int count = 0;
        int res = 0;
        int index = 0;
        while (count < truckSize){
            if (truckSize - count >= boxTypes[index][0]){
                res += boxTypes[index][0] * boxTypes[index][1];
                index++;
                count += boxTypes[index][1];
            }else{
                res += (truckSize - count) * boxTypes[index][1];
                count = truckSize;
            }
        }
        return res;
    }
}
