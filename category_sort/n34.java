public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int lo = 0;
        int hi = n - 1;
        int[] res = new int[2];
        
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo)/2;
            if (nums[mid] >= target) hi = mid;
            else lo = mid;
        }
        
        if(nums[lo] == target){
            res[0] = lo;
        }
        else if(nums[hi] == target){
            res[0] = hi;
        }
        else{
            res[0] = res[1] = -1;
            return res;
        }
        
        lo = 0;
        hi = n - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo)/2;
            if (nums[mid] <= target) lo = mid;
            else hi = mid;
        }
        
        if(nums[hi] == target){
            res[1] = hi;
        }
        else if(nums[lo] == target){
            res[1] = lo;
        }
        else{
            res[0] = res[1] = -1;
            return res;
        }
        return res;
    }
}
