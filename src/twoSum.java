public class twoSum {
    //solution one   brute force
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                if (numbers[i] + numbers[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }

    //solution two   binary search
    public int[] twoSum2(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n; i++){
            int x = numbers[i];
            int j = binarySearch(target - numbers[i], numbers, i);
            if (j != -1){
                return new int[]{i + 1, j + 1};
            }
        }
        return new int[2];
    }

    private int binarySearch(int target, int[] numbers, int l) {
        int r = numbers.length - 1;//前闭后闭
        while (l <= r){
            int m = l + (r - l)/2;
            if (numbers[m] == target){
                return m;
            }else if (numbers[m] > target){
                r = m - 1;
            }else {
                l = m + 1;
            }
        }
        return -1;
    }

    //solution three    two pointers
    public int[] twoSum3(int[] numbers, int target) {
        int n = numbers.length;
        int l = 0, r = n - 1;
        while (l <= r){
            if (numbers[l] + numbers[r] == target){
                return new int[]{l + 1, r + 1};
            }else if(numbers[l] + numbers[r] < target){
                l++;
            }else{
                r--;
            }
        }
        return new int[2];
    }

}
