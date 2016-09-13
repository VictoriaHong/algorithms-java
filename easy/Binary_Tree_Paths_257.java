// Binary Tree Paths
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, res, new StringBuilder());
        return res;
    }
    
    public void dfs(TreeNode node, List<String> res, StringBuilder sb) {
        StringBuilder cur = new StringBuilder(sb.toString());
        cur.append("->");
        cur.append(node.val);
        if (node.left == null && node.right == null) {
            res.add(cur.toString().substring(2));
        }
        if (node.left != null) {
            dfs(node.left, res, cur);
        }
        if (node.right != null) {
            dfs(node.right, res, cur);
        }
    }
}
