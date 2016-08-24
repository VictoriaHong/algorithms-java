// Remove Duplicates from Sorted Array II
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        if (n == 1 || n == 2) return n;
        
        int i = 2;
        int pre1 = nums[1];
        int pre2 = nums[0]; // pre 2 may be overwitten by copy, save it
        for (int j = 2; j < n; j++) {
            if (nums[j] != pre2) {
                pre2 = pre1;
                pre1 = nums[j];
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}
