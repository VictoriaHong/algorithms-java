// Trapping Rain Water s: O(n) t: O(n)
// calculate by layer
public class Solution {
    public int trap(int[] height) {
        if (height == null) return 0;
        int n = height.length;
        Stack<Integer> s = new Stack<>();
        int i = 0;
        int res = 0;
        while (i < n) {
            if (s.isEmpty() || height[s.peek()] >= height[i]) s.push(i); // store decresing height
            else {
                while (!s.isEmpty() && height[s.peek()] < height[i]) {
                    int x = s.pop(); // pos to calculate
                    if (!s.isEmpty()) {
                        int j = s.peek(); // pos before x where height[j] >= height[x]
                        res += (i - j - 1) * (Math.min(height[i], height[j]) - height[x]); // can hold water only when h[j]>h[x]
                    }
                }
                s.push(i); // h[i] layer not calculate yet
            }
            i++;
        }
        return res;
    }
}

// two pointers
public class Solution {
    public int trap(int[] height) {
        if (height == null) return 0;
        int n = height.length;
        int i = 0;
        int j = n - 1;
        int sum = 0;
        int minh = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                minh = height[i];
                while (i < j && height[i] <= minh) {
                    sum += minh - height[i];
                    i++;
                }
            }
            else {
                minh = height[j];
                while (i < j && height[j] <= minh) {
                    sum += minh - height[j];
                    j--;
                }
            }
        }
        return sum;
    }
}
