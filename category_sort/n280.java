// s: O(1) t: O(N)
public class Solution {
   public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if ((i%2 == 1 && nums[i] < nums[i - 1]) || (i%2 == 0 && nums[i] > nums[i - 1])) {
               swap(nums, i-1, i); 
            }
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
