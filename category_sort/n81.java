// With duplicates
public class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return false;
        
        int lo = 0;
        int hi = n - 1;
        
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo)/2;
            if (nums[mid]==target) {
                return true;
            }
            else if (nums[mid] > nums[hi]) { // left half
                if (nums[mid] > target && target >= nums[lo]) hi = mid; // left to mid is non-rotated
                else lo = mid;
            }
            else if (nums[mid] < nums[lo]) { // right half
                if (nums[mid] < target && target <= nums[hi]) lo = mid; // right to mid is non-rotated
                else hi = mid;
            }
            else { // can’t decide which part should choose, then just search every possible position
                if (nums[lo] == target) return true;
                lo++;
            }
        }
        
        if (nums[lo] == target || nums[hi] == target) return true;
        return false;
    }
}
