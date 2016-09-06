// Flip Game II
// hashmap to speed up dfs, dealing with reoccurred case
public class Solution {
    public boolean canWin(String s) {
        HashMap<String, Boolean> cache = new HashMap<>();
        return helper(s, cache);
    }
    
    public boolean helper(String s, HashMap<String, Boolean> cache) {
        if (cache.containsKey(s)) return cache.get(s);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == '+' && s.charAt(i) == '+') {
                String ns = s.substring(0, i - 1) + "--" + s.substring(i + 1, s.length());
                if (!helper(ns, cache)) {
                    cache.put(s, true);
                    return true;
                }
            }
        }
        cache.put(s, false);
        return false;
    }
}
