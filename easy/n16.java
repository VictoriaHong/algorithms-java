// 3Sum Closest
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = 0;
        int del = Integer.MAX_VALUE;
        int n = nums.length;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) return target;
                else {
                    if (Math.abs(sum - target) < del) {
                        del = Math.abs(sum - target);
                        res = sum;
                    }
                    if (sum > target) k--;
                    else j++;
                }
            }
        }
        return res;
    }
}
