// Word Search
public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        char[] letters = word.toCharArray();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, visited, i, j, letters, 0)) return true;
            }
        }
        return false;
    }
    
    public boolean search(char[][] board, boolean[][] visited, int i, int j, char[] letters, int index) {
        if (index >= letters.length) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if (visited[i][j]) return false;
        visited[i][j] = true;
        boolean res = false;
        if (board[i][j] == letters[index]) {
            res = search(board, visited, i, j - 1, letters, index + 1) ||
                  search(board, visited, i, j + 1, letters, index + 1) ||
                  search(board, visited, i - 1, j, letters, index + 1) ||
                  search(board, visited, i + 1, j, letters, index + 1);
        }
        visited[i][j] = false;
        return res;
    }
}
