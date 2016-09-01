// Group Anagrams
// hashmap + sort
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) return res;
        
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++) {
            char[] tmp = strs[i].toCharArray();
            Arrays.sort(tmp);
            String ts = new String(tmp);
            if (map.containsKey(ts)) {
                ArrayList<String> list = map.get(ts);
                list.add(strs[i]);
                map.put(ts, list);
            }
            else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(ts, list);
            }
        }
        
        for (ArrayList<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }
}
