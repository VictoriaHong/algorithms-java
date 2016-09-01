// Palindrome Partitioning
// dfs 
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) return res;
        char[] letters = s.toCharArray();
        find(letters, 0, new ArrayList<String>(), res);
        
        return res;
    }
    
    public void find(char[] letters, int start, List<String> tmp, List<List<String>> res) {
        if (start >= letters.length) {
            res.add(new ArrayList<String>(tmp));
        }
        
        for (int i = start; i < letters.length; i++) {
            if (isPal(letters, start, i)) {
                tmp.add(new String(letters, start, i - start + 1));
                find(letters, i + 1, tmp, res);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
    
    public boolean isPal(char[] letters, int i, int j) {
        if (i == j) return true;
        while (i < j) {
            if (letters[i++] != letters[j--]) return false;
        }
        return true;
    }
}

// dfs + dp
// dp[i][j] = s[i:j]is palindrome or not
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                }
            }
        }
        helper(res, new ArrayList<>(), dp, s, 0);
        return res;
    }
    
    private void helper(List<List<String>> res, List<String> path, boolean[][] dp, String s, int pos) {
        if(pos == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = pos; i < s.length(); i++) {
            if(dp[pos][i]) {
                path.add(s.substring(pos,i+1));
                helper(res, path, dp, s, i+1);
                path.remove(path.size()-1);
            }
        }
    }
}

// https://discuss.leetcode.com/topic/37756/java-dp-dfs-solution 
