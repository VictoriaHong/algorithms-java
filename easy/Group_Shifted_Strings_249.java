// Group Shifted Strings
public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (strings == null) return res;
        
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String s : strings) {
            String ss = shift(s);
            if(map.containsKey(ss)) {
                ArrayList<String> list = map.get(ss);
                list.add(s);
                map.put(ss, list);
            }
            else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(s);
                map.put(ss, list);
            }
        }
        
        for (String k :map.keySet()) {
            res.add(map.get(k));
        }
        return res;
    }
    
    public String shift(String s) {
        char[] c = s.toCharArray();
        int offset = c[0] - 'a';
        for (int i = 0; i < c.length; i++) {
            c[i] -= offset;
            if (c[i] < 'a') c[i] += 26;
        }
        return new String(c);
    }
}
