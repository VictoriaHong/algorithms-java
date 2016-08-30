// Binary Tree Level Order Traversal
// queue
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        q.offer(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> tmp = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                tmp.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}

// dfs
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        
        int currlevel = 0;
        int maxlevel = 0;
        while (true) {
            List<Integer> level = new ArrayList<Integer>();
            dfs(root, level, currlevel, maxlevel);
            if (level.size() == 0) break;
            res.add(level);
            maxlevel++;
        }
        return res;
    }
    
    public void dfs(TreeNode node, List<Integer> level, int currlevel, int maxlevel) {
        if (node == null || currlevel > maxlevel) return;
        
        if (currlevel  == maxlevel) level.add(node.val);
        
        dfs(node.left, level, currlevel + 1, maxlevel);
        dfs(node.right, level, currlevel + 1, maxlevel);
    }
}
