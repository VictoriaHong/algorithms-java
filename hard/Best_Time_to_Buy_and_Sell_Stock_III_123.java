// Best Time to Buy and Sell Stock III
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int n = prices.length;
        int[] profit = new int[n - 1];
        for (int i = 1; i < n; i++) {
            profit[i - 1] = prices[i] - prices[i - 1];
        }
        
        int[] leftsum = new int[n];
        int[] rightsum = new int[n];
        
        leftsum[0] = 0;
        int[] f = new int[2];
        f[0] = 0;
        for (int i = 1; i < n; i++) {
            f[i%2] = Math.max(f[(i - 1)%2] + profit[i - 1], profit[i - 1]);
            leftsum[i] = Math.max(leftsum[i - 1], f[i%2]);
        }
        
        rightsum[n - 1] = 0;
        f = new int[2];
        f[(n - 1)%2] = 0;
        for (int i = n - 2; i >= 0; i--) {
            f[i%2] = Math.max(f[(i + 1)%2] + profit[i], profit[i]);
            rightsum[i] = Math.max(rightsum[i + 1], f[i%2]);
        }
        
        for (int i = 0; i < n; i++) {
            max = Math.max(max, leftsum[i] + rightsum[i]);
        }
        return max;
    }
}
