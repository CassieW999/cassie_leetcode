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


                          ////////////////       解题思路        ///////////////////
    //这种思路就是最直观的扫描合并然后取中间值，虽然通过了但是并没有符合follow up的时间复杂度要求
    //时间复杂度的要求为log(m+n)，显然是需要我们采取二分
    public double findMedianSortedArrays2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
