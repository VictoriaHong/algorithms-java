// Minimum Window Substring
// 2 pointers + hashmap
public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null) return "";
        HashMap<Character, Integer> ss = new HashMap<>();
        HashMap<Character, Integer> tt = new HashMap<>();
        
        for (char c: t.toCharArray()) tt.put(c, tt.containsKey(c)?tt.get(c)+1:1);
        for (char c: t.toCharArray()) ss.put(c, 0); // initialize ss for find, ss at least contains all eles in tt
        
        // iterate s, two pointers: i(lo), hi
        int hi = 0;
        int min = Integer.MAX_VALUE;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            while(hi < s.length() && !find(tt, ss)) { // not find all eles in t
                char c = s.charAt(hi);
                ss.put(c, ss.containsKey(c)?ss.get(c)+1:1);
                hi++;
            }
            if (find(tt, ss) && min > hi-i+1) {
                min = hi-i+1;
                res = s.substring(i, hi); // hi already add 1 in while loop
            }
            ss.put(s.charAt(i), ss.get(s.charAt(i))-1); // remove i from ss
        }
        return res;
    }
    
    public boolean find(HashMap<Character, Integer> tt, HashMap<Character, Integer> ss) {
        for (char c : tt.keySet()) {
            if (tt.get(c) > ss.get(c)) return false;
        }
        return true;
    }
}

// 2 pointers + array O(n)
public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null) return "";
        int[] ss = new int[256];
        int[] tt = new int[256];
        
        for (char c: t.toCharArray()) tt[c]++;
        
        int i = 0; // girl
        int j = 0; // boy
        int min = Integer.MAX_VALUE;
        String res = "";
        for (; i < s.length(); i++) {
            char cur = s.charAt(i);
            ss[cur]++;
            if (find(tt, ss)) {
                while (j <= i && find(tt, ss)) { // move j to narrow the min substring
                    if (min > i - j + 1) {
                        min = i - j + 1;
                        res = s.substring(j, i + 1);
                    }
                    ss[s.charAt(j++)]--; // remove useless letter in ss
                } // when break, means can't move j farther to hold all letters in tt, j now points to new beginning of substring
            } // not find, move i
        }

        return res;
    }
    
    public boolean find(int[] tt, int[] ss) {
        for (int i = 0; i < tt.length; i++) {
            if (tt[i] > ss[i]) return false;
        }
        return true;
    }
}
