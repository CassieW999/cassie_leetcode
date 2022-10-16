public class containerWithMostWater {
    public static int containerWithMostWater(int[] height){
        int max = 0;
        int left = 0, right = height.length - 1;
        while (left < right){
            int curArea = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(curArea, max);
            if (height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {2,3,4,5,18,17,6};
        System.out.println(containerWithMostWater(height));
    }
}
