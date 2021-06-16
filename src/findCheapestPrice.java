//import java.util.Comparator;
//import java.util.PriorityQueue;
//
//public class findCheapestPrice {
//    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
//        // build a graph with cost
//        int[][] graph = new int[n][n];
//        for (int i = 0; i < flights.length; i++) {
//            graph[flights[i][0]][flights[i][1]] = flights[i][2];
//        }
//        // use a priority queue
//        PriorityQueue<int[]> pg = new PriorityQueue(Comparator.comparingInt(a --> a[1]));
//        pg.add(new int[]{src, 0, K + 1});
//
//        while (!pg.isEmpty()){
//            int[] front = pg.poll();
//            int start = front[0];
//            int cost = front[1];
//            int k = front[2];
//
//            if (start == dst){
//                return cost;
//            }
//
//            if (k > 0){
//                for (int i = 0; i < n; i++) {
//                    if (graph[start][i] != 0){
//                        pg.add(new int[]{i, cost + graph[start][i], k - 1});
//                    }
//                }
//            }
//        }
//        return -1;
//    }
//}
