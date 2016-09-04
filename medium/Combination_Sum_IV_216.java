// Combination Sum IV
//
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        
        // dp[i] = num of combination with sum = i
        int[] dp = new int[target + 1];
        
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    //if we want to add num to sum and make the combination equal to target，
                    //then the sum should be i - num. f[i - num] is  the number of combinations
                    //when sum is equal to i - num. So after we add num, the sum will be i, 
                    //which is what we want here. we iterate all possible num to get all cases 
                    //which can be added up to i.
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}

// follow up: What if negative numbers are allowed in the given array?
/*
if there are negative numbers in the array, we must add a requirement that each number is only used one time, or either positive number or negative number should be used only one time, otherwise there would be infinite possible combinations.
For example, we are given:
{1, -1}, target = 1,
it's obvious to see as long as we choose n 1s and (n-1) -1s, it always sums up to 1, n can be any value >= 1.
*/
