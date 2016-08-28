// Word Break t: O(nl)
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        int maxLen = getMaxLength(wordDict);
        
        dp[0] = true;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= maxLen && j <= i; j++) {
                if (dp[i - j] && inDict(s, wordDict, i - j, i)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[n];
    }
    
    public boolean inDict(String s, Set<String> wordDict, int x, int y) {
        String word = s.substring(x, y);
        if (wordDict.contains(word)) return true;
        return false;
    }
    
    // reduce time complexity from O(n^2) to O(nl), because word has 4~5 avr length
    public int getMaxLength(Set<String> dict) { 
        int maxLength = 0;
        for (String s : dict) {
            if (s.length() > maxLength) {
                maxLength = s.length();
            }
        }
        return maxLength;
    }
}
