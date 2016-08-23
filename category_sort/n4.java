// Median of Two Sorted Arrays t: O(lg(m + n))
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        int k1 = (n1 + n2 + 1) / 2;
        int v1 = findKth(nums1, 0, nums2, 0, k1);
        int v2 = v1;
        if ((n1 + n2) % 2 == 0) v2 = findKth(nums1, 0, nums2, 0, k1 + 1);
        
        return (v1 + v2)/2.0;
    }
    
    public int findKth(int[] nums1, int i1, int[] nums2, int i2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if ((n1 - i1) > (n2 - i2)) return findKth(nums2, i2, nums1, i1, k);
        if (n1 == i1) return nums2[k - 1];
        
        if (k == 1) return Math.min(nums1[i1], nums2[i2]);
        
        int k1 = Math.min(k/2, n1 - i1);
        int k2 = k - k1;
        
        if (nums1[i1 + k1 - 1] <= nums2[i2 + k2 - 1])
            return findKth(nums1, i1 + k1, nums2, i2, k - k1);
        else return findKth(nums1, i1, nums2, i2 + k2, k - k2);
    }
}
