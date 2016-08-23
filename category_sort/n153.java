// Find Minimum in Rotated Sorted Array

/**
If rotated, at bigger part: nums[mid] > nums[lo] && nums[mid] > nums[hi], go to smaller part: lo = mid;
           at smaller part: nums[mid] < nums[lo] && nums[mid] < nums[hi], go to smallest: hi = mid;
If not, nums[mid] always < nums[hi], hi = mid;

combine: nums[mid] > nums[hi], lo = mid; nums[mid] < nums[hi], hi = mid;

lo and hi are always on different side so that you can identify two parts by rules above.

**/
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
            if (nums[mid] > nums[hi]) { // left
                lo = mid;
            }
            else { // right
                hi = mid;
            }
        }
        
        if (nums[lo] < nums[hi]) return nums[lo];
        return nums[hi];
    }
}
