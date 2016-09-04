// Combination Sum III
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> cur = new ArrayList<Integer>();
        helper(n, k, res, cur, 0, 1);
        return res;
    }
    
    public void helper(int n, int k, List<List<Integer>> res, List<Integer> cur, int sum, int pos) {
        if (sum > n || cur.size() > k) return;
        if (n == sum && cur.size() == k) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        
        for (int i = pos; i < 10; i++) {
            cur.add(i);
            helper(n, k, res, cur, sum + i, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
