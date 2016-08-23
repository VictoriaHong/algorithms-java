// Reverse Vowels of a String t: O(n)
public class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        int lo = 0;
        int hi = n - 1;
        char[] ss = s.toCharArray();

        while (lo < hi) {
            while (!isVowel(ss[lo]) && lo < hi) {
                lo++;
            };
            while (!isVowel(ss[hi]) && hi > lo) {
                hi--;
            };
            swap(ss, lo, hi);
            lo++;
            hi--;
        }
        return new String(ss);
    }
    public void swap(char[] c, int lo, int hi) {
        char temp = c[lo];
        c[lo] = c[hi];
        c[hi] = temp;
    }
    public boolean isVowel(char c) {
        if (c == 'a'||c == 'e'||c == 'i'||c == 'o'||c == 'u'||c == 'A'||c == 'E'||c == 'I'||c == 'O'||c == 'U')
            return true;
        else return false;
    }
}
