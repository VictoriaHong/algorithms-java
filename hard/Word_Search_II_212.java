// Word Search II
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, root, res, i, j);
            }
        }
        return res;
    }
    
    public void dfs(char[][] board, TrieNode p, List<String> res, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {
            res.add(p.word);
            p.word = null; // de-duplicate
        }

        board[i][j] = '#';
        dfs(board, p, res, i + 1, j);
        dfs(board, p, res, i - 1, j);
        dfs(board, p, res, i, j + 1);
        dfs(board, p, res, i, j - 1);
        board[i][j] = c;
    }
    
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            char[] ww = w.toCharArray();
            for (char c : ww) {
                int i = c - 'a';
                if (p.next[i] == null) {
                    p.next[i] = new TrieNode();
                }
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }
    
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}

// https://discuss.leetcode.com/topic/33246/java-15ms-easiest-solution-100-00
