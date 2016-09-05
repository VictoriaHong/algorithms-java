// Number of Islands II
// 2d --> 1d index : id = x * n + y
// treat pos as new v, check 4 dir to see if they can be joined
public class Solution {
    int m, n;
    int[] parents;
    int[] ranks;
    int numIslands;
    public List<Integer> numIslands2(int m, int n, int[][] positions){
        numIslands = 0;
        this.m = m;
        this.n = n;
        int maxId = xy2id(m - 1, n - 1);
        parents = new int[maxId + 1];
        ranks = new int[maxId + 1];
        Arrays.fill(parents, -1);
        Arrays.fill(ranks, -1);
        List<Integer> res = new ArrayList<>();
        for(int[] island: positions) {
            update(island);
            res.add(numIslands);
        }
        return res;
    }
    private void update(int[] island) {
        int x = island[0]; int y = island[1];
        int id = xy2id(x, y);
        if(parents[id] == -1) makeSet(id);
        if(x > 0) {
            int upId = xy2id(x - 1, y);
            if(parents[upId] != -1 && notInSameSet(id, upId)) union(id, upId);
        }
        if(x < m - 1) {
            int downId = xy2id(x + 1, y);
            if(parents[downId] != -1 && notInSameSet(id, downId)) union(id, downId);
        }
        if(y > 0) {
            int leftId = xy2id(x, y - 1);
            if(parents[leftId] != -1 && notInSameSet(id, leftId)) union(id, leftId);
        }
        if(y < n - 1) {
            int rightId = xy2id(x, y + 1);
            if(parents[rightId] != -1 && notInSameSet(id, rightId)) union(id, rightId);
        }
    }
    private boolean notInSameSet(int id1, int id2){
        return findSet(id1) != findSet(id2);
    }
    private void makeSet(int id) {
        parents[id] = id;
        ranks[id] = 0;
        numIslands++;
    }
    private void union(int id1, int id2) {
        int root1 = findSet(id1);
        int root2 = findSet(id2);
        // For balancing, connect the root of shallower tree 
        // as the child of the root of the deeper tree
        if(ranks[root1] > ranks[root2]) {
            parents[root2] = root1;
        } else {    
            parents[root1] = root2;
            if(ranks[root1] == ranks[root2])
                ranks[root2]++;
        }
        numIslands--;
    }
    private int findSet(int id) {
        if(parents[id] != id)
            return findSet(parents[id]);
        else return id;
    }
    // Convert from 2D to 1D
    private int xy2id(int row, int col) { 
        return row * n + col;
    }
}
