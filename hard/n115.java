// Distinct Subsequences
public class Solution {
    public int numDistinct(String s, String t) {
        if (s == null || t == null) return 0;
        int sl = s.length();
        int tl = t.length();
        
        // dp[i][j] = count the number of distinct subsequences of T[0,j-1] in S[0,i-1] 
        int[][] dp = new int[sl+1][tl+1];
        
        for (int j = 1; j <= tl; j++) {
            dp[0][j] = 0;
        }
        for (int i = 0; i <= sl; i++) {
            dp[i][0] = 1;
        }
        
        for (int i = 1; i <= sl; i++) {
            for (int j = 1; j <= tl; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                else dp[i][j] = dp[i - 1][j];
            }
        }
        
        return dp[sl][tl];
    }
}
