// Excel Sheet Column Number
// 26进制
public class Solution {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        int i = 0;
        while (i < s.length()) {
            res = res * 26 + s.charAt(i) - 'A' + 1;
            i++;
        }
        return res;
    }
}
