import java.util.Arrays;

public class ServerSelection {
    public static int max;
    public static void main(String[] args) {
//        int[][]arr = {{1, 3, 1}, {3, 1, 1}, {1, 2, 2}, {1, 1, 3}};
//        int[][] arr = {{5, 1, 3}, {5, 2, 1}, {3, 2, 1}};
        int[][] arr = {{5, 3, 3}, {3, 4, 6}, {2, 4, 1}, {2, 1, 6}};
        int ans = getMaxNetVul(arr);
        System.out.println(ans);
    }

    private static int getMaxNetVul(int[][] arr) {
        int n = arr.length, m = arr[0].length;
        max = 0;
        int[] curList = new int[m];
        dfs(arr, 0, m-1, curList);
        return max;
    }

    private static void dfs(int[][] arr, int idx, int m, int[] curList) {
        if (m == 0){
            max = Math.max(max, Arrays.stream(curList).min().getAsInt());
            return;
        }
        if (idx >= arr.length) return;

        for (int i = idx; i < arr.length; i++){
            dfs(arr, i + 1, m - 1, getMergedMax(curList, arr[i]));
        }
    }

    private static int[] getMergedMax(int[] path, int[] cur) {
        int[] res = new int[path.length];
        for (int i = 0; i < path.length; i++) {
            res[i] = Math.max(path[i], cur[i]);
        }
        return res;
    }
}
