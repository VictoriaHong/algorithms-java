// Lowest Common Ancestor of a Binary Tree
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left == null && right == null) return null;
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
}

// iterative
/*
The idea is when finding p or q the first time current stack must contain LCA. So when stack size is decreased the pop node could be the LCA if another node (p or q) is found under it.
size is used to find the lowest ancestor. After find only p or q, size is set tostack size of p or q. In the process of finding another node, keep update size. 
*/
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null|| root == p || root == q) return root;

        TreeNode n = root;
        TreeNode res = null;
        int size = -1;
        Stack<TreeNode> s = new Stack<TreeNode>();
        while (n!=null || !s.empty()) {
            while (n!=null) {
                s.push(n);
                if (n == p || n == q) {
                    if (res == null) { //find p or q the first time
                        res = n;
                        size = s.size();
                    } else return res; //find both p and q
                }
                n = n.left;
            }
            n = s.pop();
            if (s.size() < size) {
                size = s.size();
                res = n;
            }
            n = n.right;
        }
        return res;
    }
}
