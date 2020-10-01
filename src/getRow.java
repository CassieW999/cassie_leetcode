import java.util.ArrayList;
import java.util.List;

public class getRow {
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curArr = new ArrayList<>();
        curArr.add(1);
        if (rowIndex == 0){
            return curArr;
        }
        res.add(curArr);
        int index = 1;
        while(index <= rowIndex){
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
        return res.get(res.size()-1);
    }

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }
}
