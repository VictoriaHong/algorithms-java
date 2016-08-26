// Paint Fence
// p(n) == p(n - 1)  != p(n - 2)  W(n) = W(n  - 2) * (k - 1)
// p(n) != p(n - 1)   W(n) = W(n -  1) * (k - 1)
// W(n) = (W(n - 1) + W(n - 2)) * (k - 1)
public class Solution {
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        if (n == 1) return k;
        if (n == 2) return k * k;
        
        int pre2 = k;
        int pre1 = k*k;
        for (int i = 2; i < n; i++) {
            int cur = (pre1 + pre2) * (k - 1);
            pre2 = pre1;
            pre1 = cur;
        }
        
        return pre1;
    }
}
