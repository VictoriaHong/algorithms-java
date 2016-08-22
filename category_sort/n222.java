// A tree can be presented as an 1-based array. cur is the max index. left index = parent * 2, right index = parent * 2 + 1
// h levels, in each level, get depth cost O(h - currentH), total: O(lgn * lgn)
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return count(root, 1);
    }
    
    public int count(TreeNode node, int cur) {
        if (node.left == null && node.right == null) return cur; // last level
        
        if (depth(node.left, 1) == depth(node.right, 1)) {
            return count(node.right, cur*2 + 1);
        }
        else return count(node.left, cur*2);
    }
    
    public int depth(TreeNode node, int dep) {
        return (node == null)? dep - 1: depth(node.left, dep + 1);
    }
}
