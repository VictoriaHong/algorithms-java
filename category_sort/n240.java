// Search a 2D Matrix II: first element can greater than the last element in previous line
// search from top right; if val > target, since val is smallest in this col, so target won't be in this col;
// if val < target, since val is the greatest in this row, so target won't be in this row.

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        if (n == 0) return false;
        
        int row = 0;
        int col = n - 1;
        
        while (row < m && col >= 0) {
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) col--;
            else row++;
        }
        return false;
    }
}
