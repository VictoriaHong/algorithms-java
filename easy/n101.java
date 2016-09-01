// Symmetric Tree
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode node1, TreeNode node2) {
        if ((node1 != null && node2 == null) || (node1 == null && node2 != null)) return false;
        if (node1 == null && node2 == null) return true;
        boolean res1 = helper(node1.left, node2.right);
        boolean res2 = helper(node1.right, node2.left);
        return node1.val == node2.val && res1 && res2;
    }
}
