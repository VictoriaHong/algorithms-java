// if target == a value, add ahead t: O(lgn)
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return 0;
        if (nums[n - 1] < target) return n;
        if (nums[0] >= target) return 0;
        
        int lo = 0;
        int hi = n - 1;
        
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo)/2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) hi = mid;
            else lo = mid;
        }
        
        if (target <= nums[lo]) return lo;
        else return hi;
    }
}
