import java.util.*;

public class minimumCostConnections {
    class Connections{
        String first;
        String last;
        int cost;
        public Connections(){}
        public Connections (String first, String last, int cost){
            this.first = first;
            this.last = last;
            this.cost = cost;
        }
    }

    class UnionFind{
        int[] parent;
        int[] size;
        int count;
        public UnionFind(int n){
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 0;
            }
            count = n;
        }
        public boolean isConnected(int a, int b){
            return find(a) == find(b);
        }
        public int find(int x){
            if (parent[x] == parent[parent[x]]){
                x = parent[x];
            }
            return x;
        }
        public void union(int a, int b){
            int rootA = find(a);
            int rootB = find(b);
            if (size[rootA] >= size[rootB]){
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
            }else{
                parent[rootA] = rootB;
                size[rootB] += size[rootA];
            }
            count--;
        }
    }

    public Map<String, Integer> stationID;
    public int IDIdx;
    public List<Connections> getMinimumConnections(Connections[] connections, int N){
        UnionFind uf = new UnionFind(N);
        stationID = new HashMap<>();
        IDIdx = 0;
        List<Connections> res = new ArrayList<>();
        Arrays.sort(connections, (Connections a, Connections b) -> (a.cost - b.cost));
        for (int i = 0; i < connections.length; i++) {
            Connections c = connections[i];
            int first = stationID.getOrDefault(c.first, IDIdx++);
            int last = stationID.getOrDefault(c.last, IDIdx++);
            if (!uf.isConnected(first, last)){
                res.add(connections[i]);
                uf.union(first, last);
            }
        }
        return uf.count == 1 ? res : null;
    }
}
