import java.util.HashSet;

public class findCircleNum {
    class UnionFind{
        private int[] parent;
        public UnionFind (int n){
            this.parent = new int[n];
            for (int i = 0; i < n; i++){
                parent[i] = i;
            }
        }

        public boolean isConnected(int x, int y){
            return find(x) == find(y);
        }

        public int find(int x){
            while (x != parent[x]){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y){
            if (find(x) == find(y))return;
            parent[find(x)] = find(y);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        if (n == 0) return 0;

        UnionFind uf = new UnionFind(n + 1);

        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                if (isConnected[i][j] == 1){
                    uf.union(i, j);
                }
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++){
            int k = uf.find(i);
            if (!set.contains(k)) set.add(k);
        }
        return set.size();
    }
}
