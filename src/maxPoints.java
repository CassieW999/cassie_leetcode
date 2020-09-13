import java.util.HashMap;
import java.util.Map;

public class maxPoints {
    public int maxPoints(int[][] points) {
        if(points == null) return 0;
        if(points.length<2) return points.length;

        int ans = Integer.MIN_VALUE;


        for (int i=0;i<points.length;i++){
            Map<String,Integer> map=new HashMap<>();// to store slope(y:x) as key and it's freq aas value
            int olp=0,vp=0;//to count overlapping and vertical points resp.
            int max=0;

            //check for every point except point[i]
            for (int j=0;j<points.length && (i!=j);j++){
                int x=(points[j][0]-points[i][0]);
                int y=(points[j][1]-points[i][1]);
                int gcd=generateGCD(x,y);
                //converting the slope into string after getting the fraction to reduced format
                String key="";
                //counting overlapping points
                if(x==0 && y==0){
                    olp++;
                    continue;
                }
                //counting vertical points
                else if(x==0){
                    vp++;
                    continue;
                }
                else if(y==0){
                    key="0:0";
                    map.put(key,map.getOrDefault(key,0)+1);
                }
                else{
                    key=(y/gcd)+":"+(x/gcd);
                    map.put(key,map.getOrDefault(key,0)+1);
                }
                max = Math.max(max, map.getOrDefault(key,0));

            }

            max=Math.max(max+olp+1,vp+olp+1);
            ans=Math.max(ans,max);
        }
        return ans;
    }
    private int generateGCD(int a,int b){
        if (b==0) return a;
        else return generateGCD(b,a%b);
    }
}
