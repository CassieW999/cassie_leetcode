//import java.util.LinkedList;
//import java.util.Queue;
//
//public class findCelebrity {
//    public int findCelebrity(int n) {
//        LinkedList<Integer> q = new LinkedList<>();
//        for (int i = 0; i < n; i++) q.add(i);
//        while (q.size() > 1){
//            int a = q.getFirst();
//            int b = q.getFirst();
//            if (knows(a, b)){
//                q.addLast(b);
//            }else if (knows(b, a)){
//                q.addLast(a);
//            }
//        }
//        if (q.size() == 0) return -1;
//        int cand = q.poll();
//        int other = 0;
//        for (int j = 0; j < n; j++){
//            if (cand == j) continue;
//            if (!knows(j, cand) || knows(cand, j)) break;
//            other++;
//        }
//        if (other == n - 1) return cand;
//        return -1;
//    }
//}
