// Maximum Subarray
public class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
            min = Math.min(min, preSum[i - 1]);
            max = Math.max(max, preSum[i] - min);
        }
        return max;
    }
}
