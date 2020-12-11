public class findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedNum = new int[nums1.length + nums2.length];
        int m = 0, n = 0;
        while (m < nums1.length || n < nums2.length){
            if (m < nums1.length && n < nums2.length){
                if (nums1[m] < nums2[n]){
                    mergedNum[m+n] = nums1[m];
                    m++;
                }else{
                    mergedNum[m+n] = nums2[n];
                    n++;
                }
            }else if (m < nums1.length){
                mergedNum[m+n] = nums1[m];
                m++;
            }else{
                mergedNum[m+n] = nums2[n];
                n++;
            }
        }

        if (m == 0 && n == 0){
            return 0;
        }else if (m == 1 && n == 0){
            return nums1[0];
        }else if (m == 0 && n == 1){
            return nums2[0];
        }

        if ((m + n) % 2 == 0) {
            double res = Double.valueOf(mergedNum[(m+n)/2] + mergedNum[(m+n)/2-1])/2;
            return res;
        }else{
            return mergedNum[(m+n)/2];
        }
    }
}
