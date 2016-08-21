// inorder traversal s: O(1), t: O(k)
public class Solution {
    int count = 0;
    int val = 0;
    boolean flag = true;
    public int kthSmallest(TreeNode root, int k) {
        find(root, k);
        return val;
    }
    
    public void find(TreeNode root, int k) {
        if (root == null || !flag) return;
        
        find(root.left, k);
        count++;
        
        if (count == k) {
            flag = false;
            val = root.val;
        }
        
        find(root.right, k);
    }
}

// iterative
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int count = 0;
        int val = 0;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode node = root;
        while (!s.isEmpty() || node != null) {
            if (node != null) {
                s.add(node);
                node = node.left;
            }
            else {
                node = s.pop();
                count++;
                if (count == k) {
                    val = node.val;
                    break;
                }
                node = node.right;
            } 
        }
        return val;
    }
}
