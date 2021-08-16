import java.util.ArrayList;
import java.util.List;

public class canFinish {
    int[] visited; // 0 for novisit, 1 for visiting, 2 for visited
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length <= 1) return true;
        visited = new int[numCourses];
        // build gragh
        List<List<Integer>> gragh = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            gragh.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++){
            gragh.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        // find circle
        for (int i = 0; i < numCourses; i++){
            if (!noCircle(gragh, i, numCourses)){
                return false;
            }
        }
        return true;
    }
    public boolean noCircle(List<List<Integer>> gragh, int idx, int numCourses){
        if (visited[idx] == 1) return false;
        if (visited[idx] == 2) return true;
        visited[idx] = 1;
        List<Integer> pres = gragh.get(idx);
        for (int x : pres){
            if (!noCircle(gragh, x, numCourses)) return false;
        }
        visited[idx] = 2;
        return true;
    }
}
