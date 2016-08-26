// House Robber
public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        
        int pre2 = nums[0];
        int pre1 = Math.max(nums[0], nums[1]);
 
        for (int i = 2; i < n; i++) {
            int cur = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return Math.max(pre1, pre2);
    }
}
