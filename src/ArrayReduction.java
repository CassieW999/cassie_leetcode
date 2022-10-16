import java.util.ArrayList;
import java.util.List;

public class ArrayReduction {
    private static ArrayList<Integer> max;
    public static void main (String[] args){
        int arr[] = {0, 1, 1, 0};
        int n = arr.length;

//        List<Integer> max = new ArrayList<>();
//        for (int k = 1; k <= n; k++) {
//            List<Integer> cur = new ArrayList<>();
//            int l = 0;
//            while (l + k - 1 < n){
//                int res = getMex(arr, l, l + k - 1);
//                cur.add(res);
//                l += k;
//            }
//            if (max.size() == 0 || compareList(max, cur) == -1){
//                max = cur;
//            }
//        }
//        System.out.println(max);
        max = new ArrayList<>();
        dfs(arr, n, 0, new ArrayList<>());
        System.out.println(max);
    }

    private static void dfs(int[] arr, int n, int idx, ArrayList<Integer> path) {
        if (idx >= n){
            if (max.size() == 0 || compareList(max, path) == -1){
                max = new ArrayList<>(path);
            }
            return;
        }
        for (int k = 1; k <= n; k++){
            if (idx + k - 1 < n){
                int res = getMex(arr, idx, idx + k - 1);
                path.add(res);
                dfs(arr, n, idx + k, path);
                path.remove(path.size() - 1);
            }
        }
    }


    private static int compareList(List<Integer> list1, List<Integer> list2) {
        int n = Math.min(list1.size(), list2.size());

        for(int i = 0; i < n; i++) {
            int cmp = Integer.compare(list1.get(i), list2.get(i));
            if (cmp != 0) return cmp;
        }

        return Integer.compare(list1.size(), list2.size());
    }

    private static int getMex(int[] arr, int l, int r) {
        int rangeSize = r - l + 1;
        boolean[] flag = new boolean[rangeSize];
        int res = 0;
        for (int i = l; i <= r; i++) {
            if (arr[i] >= 0 && arr[i] < rangeSize){
                flag[arr[i]] = true;
            }
        }
        for (int i = 0; i < rangeSize; i++) {
            if (!flag[i]) return i;
        }
        return rangeSize;
    }
}
