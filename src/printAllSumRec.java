import java.util.ArrayList;
import java.util.List;

public class printAllSumRec {
    public static List<List<Integer>> printAllSumRec(int num){
        List<List<Integer>> res = new ArrayList<>();
        if (num == 1) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            res.add(temp);
            return res;
        }
        dfs(res, 0, num, new ArrayList<>());
        return res;
    }

    private static void dfs(List<List<Integer>> res, int cur, int num, List<Integer> path) {
        if (cur == num){
            res.add(new ArrayList<>(path));
            return;
        }
        if (path.size() == 0){
            for (int i = 1; i <= num / 2; i++) {
                path.add(i);
                dfs(res, cur + i, num, path);
                path.remove(path.size() - 1);
            }
        }else{
            for (int i = path.get(path.size() - 1); i < num; i++) {
                if (cur + i <= num){
                    path.add(i);
                    dfs(res, cur + i, num, path);
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println(printAllSumRec(num));
    }
}
