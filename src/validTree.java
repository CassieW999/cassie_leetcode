import java.util.*;

public class validTree {
    public boolean validTree(int n, int[][] edges) {
        if (edges == null) {
            return false;
        }
        if (edges.length != n - 1) {
            return false;
        }
        List<List<Integer>> adjacentTable = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacentTable.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacentTable.get(edge[0]).add(edge[1]);
            adjacentTable.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        valid(adjacentTable, 0, visited);
        return connected == n;
    }


    int connected = 0;

    public void valid(List<List<Integer>> adjacentTable, int v, boolean[] visited) {
        if (visited[v]) {
            return;
        }
        connected++;
        visited[v] = true;
        for (int u : adjacentTable.get(v)) {
            valid(adjacentTable, u, visited);
        }
    }
}
