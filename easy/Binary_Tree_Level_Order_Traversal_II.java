// Binary Tree Level Order Traversal II
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        
        int maxdep = 0;
        int curdep = 0;
        while (true) {
            List<Integer> level = new ArrayList<>();
            dfs(root, maxdep, curdep, level);
            if (level.size() == 0) break;
            res.add(level);
            maxdep++;
        }
        Collections.reverse(res);
        return res;
    }
    
    public void dfs(TreeNode node, int maxdep, int curdep, List<Integer> cur) {
        if (node == null || curdep > maxdep) return;
        if (maxdep == curdep) cur.add(node.val);

        dfs(node.left, maxdep, curdep + 1, cur);
        dfs(node.right, maxdep, curdep + 1, cur);
    }
}
