// Find the Difference
public class Solution {
    public char findTheDifference(String s, String t) {
        if (s == null || t == null || s.length() >= t.length()) return '0';
        char res = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            res ^= s.charAt(i) ^ t.charAt(i);
        }
        
        return res;
    }
}
