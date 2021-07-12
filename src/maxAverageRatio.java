import java.util.Comparator;
import java.util.PriorityQueue;

public class maxAverageRatio {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>(new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                double x = ((o2[0] + 1) / (o2[1] + 1) - o2[0] / o2[1]);
                double y = ((o1[0] + 1) / (o1[1] + 1) - o1[0] / o1[1]);
                if (x-y > 0) return 1;
                if (x - y < 0) return -1;
                return 0;
            }
        });
        for (int i = 0; i < classes.length; i++) {
            pq.offer(new double[]{classes[i][0], classes[i][1]});
        }
        while (extraStudents > 0){
            double[] cur = pq.poll();
            cur[0] += 1;
            cur[1] += 1;
            pq.offer(cur);
            extraStudents--;
        }
        double res = 0;
        while (!pq.isEmpty()){
            double[] c = pq.poll();
            res += (c[0] / c[1]);
        }
        return res;
    }
}
