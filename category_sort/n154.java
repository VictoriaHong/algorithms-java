// Find Minimum in Rotated Sorted Array II: with duplicates
public class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return nums[0];
        if (n == 2) return Math.min(nums[0], nums[1]);
        
        int lo = 0;
        int hi = n - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo)/2;
            if (nums[mid] > nums[hi]) lo = mid;
            else if (nums[mid] < nums[hi]) hi = mid;
            else {
                hi--;
            }
        }
        if (nums[lo] < nums[hi]) return nums[lo];
        return nums[hi];
    }
}
