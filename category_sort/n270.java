// recursive
public class Solution {
    double delta =  Double.MAX_VALUE;
    int val = 0;
    public int closestValue(TreeNode root, double target) {
        if (root == null) return val;
        
        if (Math.abs((double)root.val - target) < delta) {
            delta = Math.abs((double)root.val - target);
            val = root.val;
        }

        return root.val > target? closestValue(root.left, target) : closestValue(root.right, target);
    }
}

// iterative
public class Solution {
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(res - target)) res = root.val;
            root = root.val > target? root.left : root.right;
        }
        return res;
    }
}
