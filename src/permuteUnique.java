import java.util.*;

public class permuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        bt(list, new ArrayList<>(), nums);

        //去除重复项
        list = deleteDuplicate(list);
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

    public List<List<Integer>> deleteDuplicate(List<List<Integer>> list){
        Set<List<Integer>> keys = new HashSet<>();

        for (int i = 0; i < list.size(); i++){
            if (!keys.contains(list.get(i))){
                keys.add(list.get(i));
            }
        }
        List<List<Integer>> res = new ArrayList<>(keys);
        return res;
    }
}
