// s: O(1) t: O(n)
public class Solution {
    public void sortColors(int[] nums) {
        int i = 0;
        int j = 0;
        int k = nums.length - 1;
        
        while (j <= k) {
            if (nums[j] > 1) {
                swap(nums, j , k);
                k--;
            }
            else if (nums[j] < 1) {
                swap(nums, i , j);
                i++;
                j++;
            }
            else j++;
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
