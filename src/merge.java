public class merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, count = 0;
        int [] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);
        while (i < m || j < n){
            if (i == m){
                nums1[count] = nums2[j];
                j++;
            }else if (j == n){
                nums1[count] = nums1_copy[i];
                i++;
            }else if (nums1_copy[i] <= nums2[j]){
                nums1[count] = nums1_copy[i];
                i++;
            }else if (nums1_copy[i] > nums2[j]){
                nums1[count] = nums2[j];
                j++;
            }
            count++;
        }
    }
}
