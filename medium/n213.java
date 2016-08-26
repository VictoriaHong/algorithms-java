// House Robber II
public class Solution {
    public int rob(int[] nums) {
        if (nums == null) return 0;
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        
        int max1 = helper(nums, nums[0], nums[0], 2, n - 1);
        int max2 = helper(nums, 0, nums[1], 2, n);
        
        return Math.max(max1, max2);
    }
    
    public int helper(int[] nums, int pre2, int pre1, int lo, int hi) {
        for (int i = lo; i < hi; i++) {
            int cur = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return Math.max(pre1, pre2);
    }
}
