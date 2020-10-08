import java.util.ArrayList;
import java.util.List;

public class permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        bt(list, new ArrayList<>(), nums);
        return list;
    }

    private void bt(List<List<Integer>> list, List<Integer> temp, int[] nums){
        if(temp.size() == nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0; i< nums.length; i++){
            if(!temp.contains(nums[i])){
                temp.add(nums[i]);
                bt(list, temp, nums);
                temp.remove(temp.size()-1);
            }
        }
    }
}
