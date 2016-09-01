//  Path Sum II
// dfs
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        List<Integer> cur = new ArrayList<Integer>();
        dfs(root, sum, res, cur);
        return res;
    }
    
    public void dfs(TreeNode node, int sum, List<List<Integer>> res, List<Integer> cur) {
        if (node == null) return;
        
        cur.add(node.val);
        sum -= node.val;
        if (node.left == null && node.right == null && sum == 0) {
            res.add(new ArrayList<Integer>(cur)); // can't return, have to remove new added node
        }
        
        dfs(node.left, sum, res, cur);
        dfs(node.right, sum, res, cur);
        cur.remove(cur.size() - 1); // otherwise next dfs's cur will contain this node
    }
}
