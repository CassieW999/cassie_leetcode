import java.util.*;

public class countComponents {
    public int countComponents(int n, int[][] edges) {
        //构建图
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        //无向图，构建双边关系
        for (int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        //dfs
        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                dfs(graph, i, visited);
                count++;
            }
        }
        return count;
    }

    public void dfs(List<Integer>[] graph, int u, boolean[] visited){
        //把元素标成visited
        //dfs下属未遍历过的元素
        visited[u] = true;
        List<Integer> res = graph[u];
        for (int num : res){
            if (!visited[num]){
                dfs(graph, num, visited);
            }
        }
    }
}
