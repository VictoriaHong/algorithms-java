// Decode Ways 
public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        // dp[i] is s[0:i - 1] has # of ways to decode 
        int[] dp = new int[n + 1];
        // one way to decode ""
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            int tmp = Integer.parseInt(s.substring(i - 2, i));
            if (s.charAt(i - 1) >= '1' && s.charAt(i - 1) <= '9') dp[i] += dp[i - 1]; // end with 0 should be 10 or 20
            if (tmp >= 10 && tmp <= 26) dp[i] += dp[i - 2]; // 0x can't be decoded
        }
        return dp[n];
    }
}
