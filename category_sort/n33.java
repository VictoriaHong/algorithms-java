// t: O(lgn)
public class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        
        int lo = 0;
        int hi = n - 1;
        
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo)/2;
            if (nums[mid]==target) {
                return mid;
            }
            else if (nums[mid] >= nums[lo]) { // left half
                if (nums[mid] > target && target >= nums[lo]) hi = mid; // mid in left half but target in right
                else lo = mid;
            }
            else { // right half
                if (nums[mid] < target && target <= nums[hi]) lo = mid; // mid in right half but target in left
                else hi = mid;
            }
        }
        
        if (nums[lo] == target) return lo;
        if (nums[hi] == target) return hi;
        return -1;
    }
}
