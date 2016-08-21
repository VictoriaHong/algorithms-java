// s: O(c) t: O(n + k log(n))
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = m;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            k, (o1, o2) -> matrix[o1[0]][o1[1]] - matrix[o2[0]][o2[1]]);
            
        for (int j = 0; j < n; j++) pq.offer(new int[] {0, j}); // put all possible smallest value into pq
        
        for (int i = 0; i < k - 1; i++) { // iterate k - 1 times, remove k - 1 smallests, then peek is kth smallest
            int[] cur = pq.poll();
            if (cur[0] == m - 1) continue; // last row
            pq.offer(new int[] {cur[0] + 1, cur[1]}); // add next val in the same column
        }
        int[] res= pq.peek();
        return matrix[res[0]][res[1]];
    }
}
