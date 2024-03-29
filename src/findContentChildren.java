import java.util.Arrays;

public class findContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0) return 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0, count = 0;

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                i++;
                count++;
            }
            j++;
        }

        return count;
    }
}
