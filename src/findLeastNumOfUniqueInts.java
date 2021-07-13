import java.util.*;

public class findLeastNumOfUniqueInts {
    public static int findLeastNumOfUniqueInts(int[] arr, int k){
        Map<Integer, Integer> group = new HashMap<Integer, Integer>();
        for (int num : arr) {
            int count = group.getOrDefault(num, 0) + 1;
            group.put(num, count);
        }

        List<int[]> freq = new ArrayList<int[]>();
        for (Map.Entry<Integer, Integer> entry : group.entrySet()) {
            int[] keyValue = {entry.getKey(), entry.getValue()};
            freq.add(keyValue);
        }
        Collections.sort(freq, new Comparator<int[]>() {
            public int compare(int[] keyValue1, int[] keyValue2) {
                return keyValue1[1] - keyValue2[1];
            }
        });

        int ans = freq.size();
        for (int i = 0; i < freq.size(); i++) {
            int occ = freq.get(i)[1];
            if (k >= occ) {
                --ans;
                k -= occ;
            } else {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,1,1,3,3,2};
        int k = 3;
        findLeastNumOfUniqueInts(arr, k);
    }
}
