// Move Zeroes s: O(1) t: O(n)
public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        
        int n = nums.length;
        int zeros = 0;
        int i = 0;
        
        while (i < n) {
            if (nums[i] == 0) {
                zeros++;
            }
            else {
                nums[i - zeros] = nums[i];
            }
            i++;
        }
        i = n - zeros;
        while (i < n) {
            nums[i] = 0;
            i++;
        }
    }
}
