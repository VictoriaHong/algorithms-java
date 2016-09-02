//
public class Solution {
    public int minSubArray(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        
        int sum = 0;
        int maxSum = 0;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.size(); i++) {
            sum = sum + nums.get(i);
            min = Math.min(min, sum - maxSum);
            maxSum = Math.max(maxSum, sum);
        }
        
        return min;
    }
}
