// Balanced Binary Tree
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return helper(root).isBal;
    }
    
    public ReturnType helper(TreeNode node) {
        if (node == null) return new ReturnType(0, true);
        ReturnType left = helper(node.left);
        ReturnType right = helper(node.right);
        
        if (!left.isBal || !right.isBal) return new ReturnType(0, false);
        if (Math.abs(left.h - right.h) > 1) return new ReturnType(0, false);
        return new ReturnType(Math.max(left.h, right.h) + 1, true);
    }
}

class ReturnType {
    int h;
    boolean isBal;
    
    public ReturnType(int h1, boolean res) {
        this.h = h1;
        this.isBal = res;
    }
}
