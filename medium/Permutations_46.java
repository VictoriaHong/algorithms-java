// Permutations
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return res;
        
        List<Integer> cur = new ArrayList<Integer>();
        helper(nums, cur, res);
        return res;
    }
    
    public void helper(int[] nums, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList(cur));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (cur.contains(nums[i])) continue;
            cur.add(nums[i]);
            helper(nums, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}

// iterative
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return res;
        List<Integer> cur = new ArrayList<Integer>();
        cur.add(nums[0]);
        res.add(cur);
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            for (int j = 0; j <= i; j++) {
                for (List<Integer> l : res) {
                    List<Integer> newl = new ArrayList<>(l);
                    newl.add(j, nums[i]);
                    ans.add(newl);
                }
            }
            res = ans;
        }
        return res;
    }
}
