// Validate Binary Search Tree
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }
    
    public boolean dfs(TreeNode node, Integer max, Integer min) {
        if (node == null) return true;
        if (max != null && node.val >= max) return false;
        if (min != null && node.val <= min) return false;
        
        return dfs(node.left, node.val, min) && dfs(node.right, max, node.val);
    }
}
