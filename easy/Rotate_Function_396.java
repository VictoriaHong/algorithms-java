// Rotate Function
public class Solution {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) return 0;
        int len = A.length;
        int sum = 0;
        int max = 0;
        int cur = 0;
        for (int  i = 0; i < len; i++) {
            sum += A[i];
            cur += i * A[i];
        }
        max = cur;
        for (int i = 1; i < len; i++) {
            cur = cur + sum - len * A[len - i];
            max = Math.max(max, cur);
        }
        return max;
    }
}
