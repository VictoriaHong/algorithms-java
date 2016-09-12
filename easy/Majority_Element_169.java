// Majority Element
// cur is a candidate
public class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int cnt = 1;
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (cur == nums[i]) cnt++;
            else if (cnt != 0) cnt--;
            else {
                cnt = 1;
                cur = nums[i];
            }
        }
        return cur;
    }
}
