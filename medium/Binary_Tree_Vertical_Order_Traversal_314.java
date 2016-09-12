// Binary Tree Vertical Order Traversal
public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<Integer> col = new LinkedList<Integer>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        q.offer(root);
        col.offer(0);

        int min = 0;
        int max = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                int curcol = col.poll();
                if (!map.containsKey(curcol)) {
                    map.put(curcol, new ArrayList<Integer>());
                }
                map.get(curcol).add(cur.val);
                if (cur.left != null) {
                    q.offer(cur.left);
                    col.offer(curcol - 1);
                    if (curcol - 1 < min) {
                        min = curcol - 1;
                    }
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                    col.offer(curcol + 1);
                    if (curcol + 1 > max) {
                        max = curcol + 1;
                    }
                }
            }
        }
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}
