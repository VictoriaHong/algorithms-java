// Maximal Square
// brute-force t: O(n^5)
// dp t: O(n^2)
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        
        // dp[i][j] is the max edge length of square whose bottom-right vertex is [i][j]
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] - '0';
            res = Math.max(dp[i][0], res);
        }
        
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j] - '0';
            res = Math.max(dp[0][j], res);
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    res = Math.max(res, dp[i][j] * dp[i][j]);
                }
            }
        }
        return res;
    }
}
