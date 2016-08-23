// Implement strStr() brute-force
public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if (haystack.length() == 0 && needle.length() == 0) return 0;
        
        for (int i = 0; i < haystack.length(); i++) {
            for (int j = 0;; j++) {
                if (j == needle.length()) return i;
                if (i + j >= haystack.length()) return -1;
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
            }
        }
        return -1;
    }
}
