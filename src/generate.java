import java.util.ArrayList;
import java.util.List;

public class generate {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curArr = new ArrayList<>();
        if (numRows == 0){
            return res;
        }
        curArr.add(1);
        res.add(curArr);
        int index = 1;
        while(index < numRows){
            List<Integer> temp = new ArrayList<>(curArr.size() + 1);
            for (int i = 0; i <= index; i++){
                if (i == 0 || i == index){
                    temp.add(1);
                }else {
                    temp.add(curArr.get(i) + curArr.get(i-1));
                }
            }
            curArr = temp;
            res.add(curArr);
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
