// Valid Palindrome
public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 1) return true;
        
        int lo = 0;
        int hi = s.length() - 1;
        
        while (lo < hi) {
            if (!isValid(s.charAt(lo))) {
                lo++;
                continue;
            }
            if (!isValid(s.charAt(hi))) {
                hi--;
                continue;
            }
            if (!isSame(s.charAt(lo), s.charAt(hi))) return false;
            lo++;
            hi--;
        }
        return true;
    }
    
    public boolean isValid(char c) {
        if ((c >= 'a' && c <= 'z')||(c >= 'A' && c <= 'Z')||(c >= '0' && c <= '9')) 
            return true;
        else return false;
    }
    
    private boolean isSame(char c1, char c2) {
        if ((c1 >= '0' && c1 <= '9') || (c2 >= '0' && c2 <= '9')){
            return c1 == c2;
        } 
        else {
            return c1 == c2 || Math.abs(c1 - c2) == 'a' - 'A';
        }
    }
}
