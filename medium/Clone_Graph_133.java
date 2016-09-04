// Clone Graph
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        
        List<UndirectedGraphNode> q = new ArrayList<>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        
        // clone node
        q.add(node);
        map.put(node, new UndirectedGraphNode(node.label));
        int start = 0;
        while (start < q.size()) {
            UndirectedGraphNode cur = q.get(start++);
            for (int i = 0; i < cur.neighbors.size(); i++) {
                UndirectedGraphNode neighbor = cur.neighbors.get(i);
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    q.add(neighbor);
                }
            }
        }
        
        // clone edges
        for (int i = 0; i < q.size(); i++) {
            UndirectedGraphNode newNode = map.get(q.get(i));
            for (int j = 0; j < q.get(i).neighbors.size(); j++) {
                newNode.neighbors.add(map.get(q.get(i).neighbors.get(j)));
            }
        }
        
        return map.get(node);
    }
}
