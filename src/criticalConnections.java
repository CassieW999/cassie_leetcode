//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class criticalConnections {
//    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
//        // make a graph
//        List<Integer>[] graph = new List[n];
//        for (int i = 0; i < connections.size(); i++){
//            List<Integer> cur = connections.get(i);
//            graph[cur.get(0)].add(cur.get(1));
//            graph[cur.get(1)].add(cur.get(0));
//        }
//        // record all the nodes not in circle
//        List<Integer> nonCircleNodeList = new ArrayList<>();
//        for (int i = 0; i < n; i++){
//            if (!isCircle(i, graph, n)){
//                nonCircleNodeList.add(i);
//            }
//        }
//        // return all the connections from the non circle nodes
//        List<List<Integer>> res = new ArrayList<>();
//        for (int node : nonCircleNodeList){
//            List<Integer> cur = graph[node];
//            for (int num : cur){
//                if (res.contains(Arrays.asList(num, node))) {
//                    continue;
//                }
//                List<Integer> ans = new ArrayList<>();
//                ans.add(node);
//                ans.add(num);
//                res.add(ans);
//            }
//        }
//        int[] id = new int[n];
//        Arrays.fill(id, -1);
//        return res;
//    }
//}
