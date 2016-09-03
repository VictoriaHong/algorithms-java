// Largest Rectangle in Histogram
// increasing stack
public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length <= 0) return 0;
        int max = 0;
        Stack<Integer> s = new Stack<Integer>();
        
        for (int i = 0; i <= heights.length; i++) {
            int cur = (i == heights.length) ? -1 : heights[i];
            while (!s.isEmpty() && heights[s.peek()] >= cur) { // pop all greater than cur
                int h = heights[s.pop()];
                int w = s.isEmpty() ? i : i - s.peek() - 1;
		// s is empty means: left: all >= cur, right: till i - 1; i and peek() is where smaller begin
                max = Math.max(max, h * w);
            }
            s.push(i);
        }
        return max;
    }
}
