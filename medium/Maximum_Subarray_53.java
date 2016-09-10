// Maximum Subarray
public class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int minSum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }
        return max;
    }
}

// 不用前缀和数组
public class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        // 滚动数组
        // f[] is current max, must include nums[i]
        // g[] is global max
        int[] f = new int[2];
        int[] g = new int[2];
        f[0] = nums[0];
        g[0] = nums[0];
        for (int i = 1; i < n; i++) {
            f[i%2] = Math.max(nums[i], f[(i - 1)%2] + nums[i]);
            g[i%2] = Math.max(f[i%2], g[(i - 1)%2]);
        }
        return g[(n - 1)%2];
    }
}
