// Merge Sorted Array
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) return;
        
        int i1 = m - 1;
        int i2 = n - 1;
        int sum = m + n - 1;
        while (sum >= 0 && i1 >= 0 && i2 >= 0) {
            if (nums1[i1] >= nums2[i2]) {
                nums1[sum--] = nums1[i1--];
            }
            else {
                nums1[sum--] = nums2[i2--];
            }
        }

        if (i1 < 0 && i2 >= 0) {
            while (sum >= 0) nums1[sum--] = nums2[i2--];
            return;
        }
        if (i1 >= 0 && i2 < 0) {
            while (sum >= 0) nums1[sum--] = nums1[i1--];
            return;
        }
    }
}
