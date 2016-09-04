// Subsets
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return res;
        List<Integer> cur = new ArrayList<Integer>();
        helper(res, cur, nums, 0);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> cur, int[] nums, int start) {
        res.add(new ArrayList<>(cur));
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            helper(res, cur, nums, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
