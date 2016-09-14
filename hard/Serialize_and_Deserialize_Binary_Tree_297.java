// Serialize and Deserialize Binary Tree
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        myserialize(root, sb);
        return sb.toString();
    }
    
    public void myserialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }
        sb.append(node.val).append(",");
        myserialize(node.left, sb);
        myserialize(node.right, sb);
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] da = data.split(",");
        Queue<String> q = new LinkedList<String>();
        for (String s : da) q.offer(s);
        return mydeserialize(q);
    }
    
    public TreeNode mydeserialize(Queue<String> q) {
        String ss = q.remove();
        if (ss.equals("null")) {
            return null;
        }
        int val = Integer.parseInt(ss);
        TreeNode root = new TreeNode(val);
        root.left = mydeserialize(q);
        root.right = mydeserialize(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
