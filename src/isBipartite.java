public class isBipartite {
    class UnionFind{
        private int[] parent;
        private int count;
        private int[] size;
        public UnionFind(int n){
            this.count = n;
            this.parent = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ)return;

            if (size[rootP] > size[rootQ]){
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }else{
                parent[rootP] = rootQ;
                size[rootQ] = rootP;
            }
            count--;
        }

        public boolean isConnected(int p, int q){
            return find(p) == find(q);
        }

        public int find(int a){
            while (parent[a] != a){
                parent[a] = parent[parent[a]];
                a = parent[a];
            }
            return a;
        }

        public int count(){
            return count;
        }
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            int[] cur = graph[i];
            for (int w : cur){
                if (uf.isConnected(w, i)){
                    return false;
                }
                uf.union(w, cur[0]);
            }
        }
        return true;
    }
}
