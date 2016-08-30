// Rotate Array
// 3 step reverse t: O(n) s: O(1)
public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        int n = nums.length;
        k %= n;
        
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }
    
    public void reverse(int[] nums, int i, int j) {
        if (i >=j) return;
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}

// t: O(n) s: O(k)
public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        int n = nums.length;
        k %= n;
        
        int[] tmp = Arrays.copyOfRange(nums, 0, n - k);
        System.arraycopy(nums, n - k, nums, 0, k);
        System.arraycopy(tmp, 0, nums, k, n - k);
    }
}
