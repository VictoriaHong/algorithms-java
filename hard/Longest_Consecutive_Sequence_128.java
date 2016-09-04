// Longest Consecutive Sequence
// t: O(n) every element in & out set once
public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        int maxlen = 1;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (!set.contains(cur)) continue;
            int len = 1;
            while (set.contains(cur - 1)) {
                len++;
                cur--;
                set.remove(cur);
            }
            cur = nums[i];
            while (set.contains(cur + 1)) {
                len++;
                cur++;
                set.remove(cur);
            }
            maxlen = Math.max(maxlen, len);
        }
        return maxlen;
    }
}
