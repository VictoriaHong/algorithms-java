// t: O(N2 + klgN1)
public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int N1 = nums1.length;
        int N2 = nums2.length;
        List<int[]> res = new ArrayList<int[]>();
        if (N1 == 0 || N2 == 0) return res;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            k, (o1, o2) -> (nums1[o1[0]] + nums2[o1[1]]) - (nums1[o2[0]] + nums2[o2[1]]));
            
        for (int i = 0; i < N2; i++) pq.offer(new int[] {0, i});
        
        while (k-- > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            res.add(new int[] {nums1[cur[0]], nums2[cur[1]]});
            if (cur[0] == N1 - 1) continue;
            pq.offer(new int[] {cur[0] + 1, cur[1]});
        }
        return res;
    }
}
