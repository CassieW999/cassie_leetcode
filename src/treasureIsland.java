//import java.util.Collections;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class treasureIsland {
//    class Point{
//        int x;
//        int y;
//        public Point(int x, int y){
//            this.x = x;
//            this.y = y;
//        }
//    }
//    public int treasureIsland(int[][] map){
//        Collections.sort();
//        int[][] directions = {{1, 0},{0, 1},{-1, 0},{0, -1}};
//        if (map == null || map.length == 0) return -1;
//        Queue<Point> q = new LinkedList<>();
//        q.add(new Point(0, 0));
//        map[0][0] = 'D';
//        while (!q.isEmpty()){
//            int size = q.size();
//            for (int i = 0; i < size; i++) {
//                Point p = q.poll();
//                for(int[] d : directions){
//                    int r = p.x + d[0];
//                    int c = p.y + d[1];
//                    if (r >= 0 && r < map.length && c >= 0 && c < map[0].length && map[r][c] != 'D'){
//                        q.add(new Point(r, c));
//                    }
//                }
//            }
//        }
//        return -1;
//    }
//}
