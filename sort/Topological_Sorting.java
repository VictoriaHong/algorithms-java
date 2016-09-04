// Topological Sorting
public class Solution {
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        if (graph == null) {
            return null;
        }
        
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        HashMap<DirectedGraphNode, Integer> map = new 
                                        HashMap<DirectedGraphNode, Integer>();
        
        // count in degree for all nodes
        for (DirectedGraphNode temp : graph) {
            for (DirectedGraphNode n : temp.neighbors) {
                if (!map.containsKey(n)) {
                    map.put(n, 1);
                }
                else {
                    map.put(n, map.get(n) + 1);
                }
            }
        }
        
        // find the node whose in degree is zero
        for (DirectedGraphNode n : graph) {
            if (!map.containsKey(n)) {
                q.offer(n);
                result.add(n);
            }
        }
        
        // walk through
        while (!q.isEmpty()) {
           DirectedGraphNode temp = q.poll();
           for (DirectedGraphNode n : temp.neighbors) {
               if (map.containsKey(n)) {
                   map.put(n, map.get(n) - 1);
                   if (map.get(n) == 0) {
                       q.offer(n);
                       result.add(n);
                   }
               }
           }
        }
        
        return result;
    }
}
