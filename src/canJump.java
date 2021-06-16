public class canJump {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightMostPos = 0;
        for (int i = 0; i <= rightMostPos; i++) {
            rightMostPos = Math.max(rightMostPos, nums[i] + i);
            if (rightMostPos >= n - 1) return true;
        }
        return false;
    }
}
