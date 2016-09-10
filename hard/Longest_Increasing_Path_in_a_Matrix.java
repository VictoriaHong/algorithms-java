// Longest Increasing Path in a Matrix
// 记忆化搜索加速Dfs
public class Solution {
    public static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] count = new int[m][n];
        int res = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = dfs(matrix, count, i, j);
                res = Math.max(len, res);
            }
        }
        return res;
    }
    
    public int dfs(int[][] matrix, int[][] count, int i, int j) {
        if (count[i][j] != 0) return count[i][j];
        int max = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= matrix[i][j]) continue;
            max = Math.max(max, 1 + dfs(matrix, count, x, y));
        }
        count[i][j] = max;
        return max;
    }
}
