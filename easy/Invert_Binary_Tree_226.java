// Invert Binary Tree
// recursive
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}

// iterative
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        Stack<TreeNode> s = new Stack<>();
        
        s.push(root);
        while(!s.isEmpty()) {
            TreeNode cur = s.pop();
            TreeNode tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;
            if (cur.left != null) s.push(cur.left);
            if (cur.right != null) s.push(cur.right);
        }
        return root;
    }
}
