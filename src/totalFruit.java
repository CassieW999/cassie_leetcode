import java.util.HashMap;
import java.util.Map;

public class totalFruit {
    //  i
    // [3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4]
    //  l
    public int totalFruit(int[] tree) {
        if (tree == null || tree.length == 0) return 0;
        int n = tree.length;

        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            map.put(tree[i], map.getOrDefault(tree[i], 0) + 1);
            while (map.size() > 2){
                map.put(tree[left], map.get(tree[left]--));
                if (map.get(tree[left]) == 0) map.remove(tree[left]);
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}
