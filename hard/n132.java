// Palindrome Partitioning II
// 区间动态规划 + 划分动态规划  t: O(n^2) with improvement(pre-calculate isPalindrome first, s: O(n^2))
public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        // first i substring mincut
        int[] dp = new int[n + 1];
        boolean[][] isPalindrom = getPalindrom(s);
        
        dp[0] = -1; // 'a': 0~1 is Palindrome, and mincut is 0, so dp[0] + 1 = 0
        // dp[i] = i - 1; at most cut i-1 times, this is a possible solution.
        for (int i = 1; i <= n; i++) dp[i] = i - 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (isPalindrom[j][i - 1]) dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        return dp[n];
    }
    
    public boolean[][] getPalindrom(String s) {
        int n = s.length();
        
        // dp[i][j] is s(i, j + 1) == palindrom
        boolean[][] dp = new boolean[n][n];
        
        // range = 0
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        // range = 1
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        
        for (int len = 2; len < n; len++) {
            for (int start = 0; start < n - len; start++) {
                dp[start][start + len] = (s.charAt(start) == s.charAt(start + len)) && ( dp[start + 1][start + len - 1]);
            }
        }
        return dp;
    }
}

// 利用palindrome对称性 t: O(n^2) s: O(1)
// odd: ..... i-j i i+j .....
// even: .....i-j-1 i-1 i i+j ....
public class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        
        // dp[i] is mincut for s[0, i - 1]
        for (int i = 0; i <= n; i++) dp[i] = i - 1;
        
        for (int i = 1; i <= n; i++) { // i is first i element[0,n], j is redius
            // s[i-j - 1, i + j - 1] is odd length
            for (int j = 0; j + 1 <= i && i + j <= n && s.charAt(i-j-1) == s.charAt(i + j - 1); j++)
                dp[i + j] = Math.min(dp[i - j - 1] + 1, dp[i + j]);
            // s[i-j, i + j - 1] is even length
            for (int j = 0; j + 2<= i && i + j <= n && s.charAt(i-j - 2) == s.charAt(i + j - 1); j++)
                dp[i + j] = Math.min(dp[i - j - 2] + 1, dp[i + j]);
        }
        return dp[n];
    }
}
// https://discuss.leetcode.com/topic/2840/my-solution-does-not-need-a-table-for-palindrome-is-it-right-it-uses-only-o-n-space
