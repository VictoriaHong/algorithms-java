// Maximum Product Subarray
// Let max[i] = the maxumum product ends with nums[i], and min[i] = the minimum product ends with nums[i]
// max[i] = max(nums[i], nums[i]*max[i-1], nums[i]*min[i-1])
// min[i] = min(nums[i], nums[i]*max[i-1], nums[i]*min[i-1])
// The max[i] and min[i] are only used once, so we can use two variable to store them
public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null) return 0;
        int curMax = nums[0];
        int curMin = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmpMax = nums[i] * curMax;
            int tmpMin = nums[i] * curMin;
            curMax = max(tmpMax, tmpMin, nums[i]);
            curMin = min(tmpMax, tmpMin, nums[i]);
            if (curMax > max) max = curMax;
        }
        return max;
    }
    
    public int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
    
    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}

// 局部最大最小+全局最大
public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null) return 0;
        int n = nums.length;
        int[] curMax = new int[2];
        int[] curMin = new int[2];
        int[] g = new int[2];
        curMax[0] = nums[0];
        curMin[0] = nums[0];
        g[0] = nums[0];
        for (int i = 1; i < n; i++) {
            curMax[i%2] = max(curMax[(i - 1)%2]*nums[i], curMin[(i - 1)%2]*nums[i], nums[i]);
            curMin[i%2] = min(curMax[(i - 1)%2]*nums[i], curMin[(i - 1)%2]*nums[i], nums[i]);
            g[i%2] = Math.max(g[(i - 1)%2], curMax[i%2]);
        }
        return g[(n - 1)%2];
    }
    
    public int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
    
    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
