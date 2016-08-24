// Container With Most Water O(n^2)
public class Solution {
    public int maxArea(int[] height) {
        int vol = Integer.MIN_VALUE;
        int n = height.length;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                vol = Math.max(vol, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return vol;
    }
}

// greedy
// two pointers: move the lower pointer each time.
// move lower, next one can be higher, result in bigger volume;
// move higher, volume must be smaller, because lower height is same but wdith is narrowed.
public class Solution {
    public int maxArea(int[] height) {
        int vol = Integer.MIN_VALUE;
        int n = height.length;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            vol = Math.max(vol, (j - i) * ((height[i] < height[j])? height[i++]:height[j--]));
        }

        return vol;
    }
}

// https://discuss.leetcode.com/topic/503/anyone-who-has-a-o-n-algorithm
