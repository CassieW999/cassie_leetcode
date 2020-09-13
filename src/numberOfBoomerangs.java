import java.util.HashMap;
import java.util.Map;

public class numberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        //遍历所有的点，对每个点求其他点到它的距离
        for (int i = 0; i < points.length; i++){
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for(int j = 0 ; j < points.length ; j ++){
                if (j != i){
                    int dis = dist(points[i],points[j]);
                    if (map.containsKey(dis)){
                        map.put(dis, map.get(dis)+1);
                    }else{
                        map.put(dis, 1);
                    }
                }
            }

            for (int dis : map.keySet()){
                res += map.get(dis) * (map.get(dis) - 1);
            }
        }
        return res;
    }

    private int dist(int[] pointa, int[] pointb){
        int res = (pointa[0] - pointb[0]) * (pointa[0] - pointb[0]) + (pointa[1] - pointb[1]) * (pointa[1] - pointb[1]);
        return res;
    }
}
