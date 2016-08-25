// Substring with Concatenation of All Words worst O(nl)
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.length() == 0 || words == null || words.length == 0) return new ArrayList<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String ss: words) map.put(ss, map.containsKey(ss)?map.get(ss)+1:1);
        
        int n = s.length();
        int l = words.length;
        int wl = words[0].length();
        for (int i = 0; i <= n - l*wl; i++) {
            Map<String, Integer> copy = new HashMap<String, Integer>(map); // words may have duplicates
            int j = 0;
            for (; j < l; j++) { // iterate words
                String ss = s.substring(i+j*wl, i+(j+1)*wl);
                if (!copy.containsKey(ss) || copy.get(ss) < 1) break; // not in words or appears more than in words
                copy.put(ss, copy.get(ss)-1); // match a word
            } 
            if (j == l) res.add(i);
        }
        return res;
    }
}
