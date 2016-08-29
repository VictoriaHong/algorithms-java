// Edit Distance O(mn)
public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return -1;
        }
        int n1 = word1.length();
        int n2 = word2.length();
        
        // dp[i][j]: word1 first i substring edit dp[i][j] times to become word2 first j substring
        int[][] dp = new int[n1 + 1][n2 + 1];
        
        // when one is empty string, min edit distance for another is length;
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n2; i++) {
            dp[0][i] = i;
        }
        
        for (int i = 1; i <=n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }
        }
        
        return dp[n1][n2];
    }
}
