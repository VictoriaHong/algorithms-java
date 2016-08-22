// t: O(lgn)
public class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 1) return n - 1;
        
        int lo = 0;
        int hi = n - 1;
        
        while (lo + 1< hi) {
            int mid = lo + (hi - lo)/2;
            if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) {
                lo = mid;
            }
            else if (nums[mid - 1] > nums[mid] && nums[mid] > nums[mid + 1]) {
                hi = mid;
            }
            else if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) return mid;
            else lo = mid;
        }
        
        if ((lo == 0 && nums[1] < nums[0]) || (lo > 0 && nums[lo - 1] < nums[lo] && nums[lo] > nums[lo + 1]))
            return lo;
        if ((hi == n - 1 && nums[n-2] < nums[n-1]) || (hi < n - 1 && nums[hi - 1] < nums[hi] && nums[hi] > nums[hi + 1])) return hi;
        return -1;
    }
}
