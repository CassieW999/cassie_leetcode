import java.util.*;

public class minTime {
//    static int ans;
//    static boolean[] visited;
//    static Map<Integer, List<Integer>> graph;
    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // build graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        // dfs
        int res = 0;
        boolean[] visited = new boolean[n];
        res = dfs(0, visited, graph, hasApple);
        return res == 0 ? 0 : (res - 1) * 2;
    }

    public static int dfs(int x, boolean[] visited, List<List<Integer>> graph, List<Boolean> hasApple){
        if (visited[x]) return 0;

        visited[x] = true;
        int cost = 0;
        for (int i : graph.get(x)){
            cost += dfs(i, visited, graph, hasApple);
        }
        if (!hasApple.get(x) && cost == 0) return 0;
        return cost + 1;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1}, {0,2}, {1,4}, {1,5}, {2,3}, {2,6}};
        int n = 7;
        Boolean[] hasApple = {false,false,true,false,true,true,false};
        System.out.println(minTime(n, edges, Arrays.asList(hasApple)));
    }
}
