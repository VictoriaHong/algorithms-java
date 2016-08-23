// Reverse String t:O(n)
public class Solution {
    public String reverseString(String s) {
        int lo = 0;
        int hi = s.length() - 1;
        char[] ss = s.toCharArray();

        while (lo < hi) {
            swap(ss, lo++, hi--);
        }
        return new String(ss);
    }
    
    public void swap(char[] c, int lo, int hi) {
        char temp = c[lo];
        c[lo] = c[hi];
        c[hi] = temp;
    }
}
