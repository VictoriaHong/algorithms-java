// Permutations II
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<Integer> cur = new ArrayList<>();
        helper(res, cur, used, nums);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> cur, boolean[] used, int[] nums) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            cur.add(nums[i]);
            helper(res, cur, used, nums);
            cur.remove(cur.size() - 1);
            used[i] = false;
        }
    }
}

