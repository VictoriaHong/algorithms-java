// Maximum Depth of Binary Tree
// dfs
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

// iterative
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int max = 0;
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(root);
        while (!s1.isEmpty()) {
            while (!s1.isEmpty()) {
                TreeNode node = s1.pop();
                if (node.left != null) s2.push(node.left);
                if (node.right != null) s2.push(node.right);
            }
            max++;
            s1 = s2;
            s2 = new Stack<TreeNode>();
        }
        return max;
    }
}
