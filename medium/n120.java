// Triangle  t: O(n^2) searched all possible path
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[][] f = new int[m][n];
        
        for (int k = 0; k < n; k++) {
            f[m - 1][k] = triangle.get(m-1).get(k);
        }
        
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
               f[i][j] = Math.min(f[i + 1][j], f[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        
        return f[0][0];
    }
}
