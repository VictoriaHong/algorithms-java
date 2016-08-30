// Binary Tree Zigzag Level Order Traversal
// bfs + reverse

// dfs + reverse
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        
        int currlevel = 0;
        int maxlevel = 0;
        while (true) {
            List<Integer> level = new ArrayList<Integer>();
            dfs(root, level, currlevel, maxlevel);
            if (level.size() == 0) break;
            if (maxlevel % 2 != 0) Collections.reverse(level);
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

// 2 stacks
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(root);
        boolean flag = false;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            while (!s1.isEmpty()) {
                TreeNode cur = s1.pop();
                level.add(cur.val);
                if (!flag) {
                    if (cur.left != null) s2.push(cur.left);
                    if (cur.right != null) s2.push(cur.right);
                }
                else {
                    if (cur.right != null) s2.push(cur.right);
                    if (cur.left != null) s2.push(cur.left);
                }
            }
            res.add(level);
            Stack<TreeNode> tmp = s1;
            s1 = s2;
            s2 = tmp;
            flag = !flag;
        }
        return res;
    }
}
