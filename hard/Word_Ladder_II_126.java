// Word Ladder II
// bfs: start from beginword, find each word's distance to beginword
// dfs: start from endword, find the neighbor who is closer to beginword, add to path 
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> map = new HashMap<>(); // k:node v:neighbors
        HashMap<String, Integer> distance = new HashMap<>(); // distance to beginword
        
        bfs(map, distance, beginWord, endWord, wordList); // create distance, map
        List<String> path = new ArrayList<String>();
        dfs(map, distance, res, path, endWord, beginWord); // search from endword, add final path which begin with cur path to res
        return res;
    }
    
    public void bfs(HashMap<String,
                ArrayList<String>> map,
                HashMap<String, Integer> distance,
                String start,
                String end,
                Set<String> set) {
        Queue<String> q = new LinkedList<String>();
        q.offer(start);
        distance.put(start, 0);
        
        for (String s : set) {
            map.put(s, new ArrayList<String>());
        }
        
        while (!q.isEmpty()) {
            String cur = q.poll();
            List<String> neighbors = expand(cur, set);
            for (String s : neighbors) {
                map.get(s).add(cur);
                if (!distance.containsKey(s)) {
                    distance.put(s, distance.get(cur) + 1);
                    q.offer(s);
                }
            }
        }
    }
    
    public void dfs(HashMap<String, ArrayList<String>> map,
                HashMap<String, Integer> distance,
                List<List<String>> res,
                List<String> path,
                String cur,
                String beginWord) {
        path.add(cur);
        if (cur.equals(beginWord)) {
            Collections.reverse(path);
            res.add(new ArrayList<String>(path));
            Collections.reverse(path);
        }
        else {
            for (String s : map.get(cur)) {
                if (distance.get(s) == distance.get(cur) - 1) 
                    dfs(map, distance, res, path, s, beginWord);
            }
        }
        path.remove(path.size() - 1);
    }
    
    // find neighbors for current word
    public List<String> expand(String crt, Set<String> dict) {
        List<String> expansion = new ArrayList<String>();

        for (int i = 0; i < crt.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch != crt.charAt(i)) {
                    String expanded = crt.substring(0, i) + ch
                            + crt.substring(i + 1);
                    if (dict.contains(expanded)) {
                        expansion.add(expanded);
                    }
                }
            }
        }

        return expansion;
    }
}

