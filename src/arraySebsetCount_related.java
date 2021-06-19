public class arraySebsetCount_related {
    //这一系列题目都是同一种思想：求子集中所有元素都满足某种条件的子集个数，即循环给定的数组，以每个元素为结尾的满足条件的和





//    ============= 母题0 ==============
//    如果让你求一个数组的连续子数组总个数，你会如何求？
//    其中连续指的是数组的索引连续。 比如 [1,3,4]，其连续子数组有：[1], [3], [4], [1,3], [3,4] , [1,3,4]，你需要返回 6。
//    一种思路是总的连续子数组个数等于：以索引为 0 结尾的子数组个数 + 以索引为 1 结尾的子数组个数 + ... + 以索引为 n - 1 结尾的子数组个数，这无疑是完备的。
    public int countSubArray(int[] nums){
        int ans = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur++;
            ans += cur;
        }
        return ans;
    }

//    ============= 母题1 ==============
//    我继续修改下题目， 如果让你求一个数组相邻差为 1 连续子数组的总个数呢？其实就是索引差 1 的同时，值也差 1。
    // [1, 2, 3, 4, 6, 7]
    public static int countSubArrayWithOne(int[] nums){
        int ans = 1;
        int cur = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] == 1){
                cur++;
            }else{
                cur = 1;
            }
            ans += cur;
        }
        return ans;
    }

    //    ============= 母题2 ==============
    //   如果我让你求出不大于 k 的子数组的个数呢？不大于 k 指的是子数组的全部元素都不大于 k。
    // [1, 2, 3, 4, 6, 7]
    public static int countSubArrayAtmostK(int[] nums, int k){
        int ans = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= k){
                cur++;
            }else{
                cur = 0;
            }
            ans += cur;
        }
        return ans;
    }

    //  ============= 母题3 ==============
    // 如果我让你求出子数组最大值刚好是 介于 k1 和 k2 的子数组的个数呢？实现函数 betweenK(k1, k2, nums)。
    // 实际上是 betweenK 可以直接利用 atMostK，即 atMostK(k1, nums) - atMostK(k2 - 1, nums)，其中 k1 > k2。
    // 前提是值是离散的， 比如上面我出的题都是整数。 因此我可以直接 减 1，因为 1 是两个整数最小的间隔。
    public static int countSubArrayWithinK1K2(int[] nums, int k1, int k2){
        return countSubArrayAtmostK(nums, k2) - countSubArrayAtmostK(nums, k1 - 1);
    }

    public static int indexEqualsValueSearch(int[] arr) {
        int left = 0, right = arr.length;
//        int x=-1;
        while (left < right){
            int mid = left + (right - left)/2;
            if (arr[mid] >= mid){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return arr[left] == left ? left : -1;
    }

    public static void main(String[] args) {
        int[] nums = {-8,1, 2,  3};
//        System.out.println(countSubArrayWithOne(nums));
        System.out.println(indexEqualsValueSearch(nums));
    }
}
