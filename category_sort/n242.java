// s: O(1) t: O(m + n)
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        
        if (s.length() == 0 || t.length() == 0) {
            return true;
        }
        
        if (s.length() != t.length()) {
            return false;
        }     
        char[] c = new char[26];   
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - 'a']++; 
        }        
        for (int i = 0; i < t.length(); i++) {
            c[t.charAt(i) - 'a']--; 
        }        
        for (int i = 0; i < c.length; i++) {
            if (c[i] != 0) {
                return false;
            } 
        }
        return true;
    }
}

