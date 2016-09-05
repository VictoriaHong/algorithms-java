// Longest Increasing Subsequence
// dp t: O(n^2)
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        // dp[i] = length of longest subsequence of first i+1 element, including nums[i]
        int[] dp = new int[nums.length];
        
        int max = 1;
        
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > max) max = dp[i]; // dp[i] may not the current biggest one, some dp[j] can be bigger.
        }
        return max;
    }
}

// dp + bs
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        // dp[i] = largest element of the LIS with length i + 1
        int[] dp = new int[nums.length];
        
        int len = 0;
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp[len]) { // a new element can be added to current longest IS
                dp[++len] = nums[i];
            }
            else { // find the first position which dp[pos] > nums[i], add nums[i] to dp[pos - 1], dp[pos] = nums[i]
                int index = find(dp, len, nums[i]);
                dp[index] = nums[i];
            }
        }
        return len + 1;
    }
    
    public int find(int[] dp, int len, int target) {
        int lo = 0;
        int hi = len;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo)/2;
            if (dp[mid] == target) return mid;
            else if (dp[mid] > target) hi = mid;
            else lo = mid;
        }
        
        if (dp[lo] >= target) return lo;
        return hi;
    }
}

// https://discuss.leetcode.com/topic/46913/o-nlogn-clean-and-easy-java-dp-binary-search-solution-with-detailed-explanation
