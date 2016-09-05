// Number of Connected Components in an Undirected Graph
// weighted union find
public class Solution {
    int count;
    int[] sz;
    int[] id;
    public int countComponents(int n, int[][] edges) {
        count = n;
        id = new int[n];
        sz = new int[n];
        
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
        
        for (int[] edge:edges) {
            int x = edge[0];
            int y = edge[1];
            if(!find(x,y)) {
                unite(x,y);
                count--;
            }
        }
        return count;
    }
    
    private int root(int i){
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
    
    private boolean find(int p,int q) {
        return root(p) == root(q);
    }
    
    private void unite(int p,int q) {
        int i = root(p);
        int j = root(q);
        if(sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        }
        else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }
}
