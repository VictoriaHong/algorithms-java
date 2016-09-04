// Combination Sum
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) return res;
        
        Arrays.sort(candidates);
        List<Integer> cur = new ArrayList<Integer>();
        helper(candidates, target, res, cur, 0, 0);
        return res;
    }
    
    public void helper(int[] c, int target, List<List<Integer>> res, List<Integer> cur, int sum, int pos) {
        if (target == sum) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        
        if (sum > target) return;
        
        for (int i = pos; i < c.length; i++) {
            cur.add(c[i]);
            helper(c, target, res, cur, sum + c[i], i); // not i + 1 because we can reuse same elements
            cur.remove(cur.size() - 1);
        }
    }
}

