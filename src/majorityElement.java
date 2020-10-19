import java.util.Arrays;

public class majorityElement {
    public int majorityElement(int[] nums) {
        /////    solution 1    //////
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : nums){
//            if (!map.containsKey(num)){
//                map.put(num, 1);
//            }else{
//                map.put(num, map.get(num) + 1);
//            }
//        }
//        int res = 0;
//        for (int key : map.keySet()){
//            if (map.get(key) > nums.length/2){
//                res = key;
//            }
//        }
//        return res;


        /////    solution 2    //////
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
