// Search a 2D Matrix t: O(lgmn)
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        if (n == 0) return false;
        if (m == 1 && n == 1) return target == matrix[0][0];
        
        int lo = 0;
        int hi = m - 1;
        int row = 0;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo)/2;
            if (matrix[mid][0] < target) lo = mid;
            else hi = mid;
        }
        row = matrix[hi][0] <= target?hi:lo;
        
        lo = 0;
        hi = n - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo)/2;
            if (matrix[row][mid] > target) hi = mid;
            else if (matrix[row][mid] < target) lo = mid;
            else return true;
        }
        if (matrix[row][lo] == target || matrix[row][hi] == target) return true;
        return false;
    }
}
