// ZigZag Conversion
public class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows == 0) return "";
        int len = s.length();
        char[] c = s.toCharArray();
        StringBuilder[] res = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            res[i] = new StringBuilder();
        }
        for (int i = 0; i < len;) {
            int row = 0;
            while (row < numRows && i < len) { // vertical down
                res[row++].append(c[i++]);
            }
            row -= 2;
            while (row > 0 && i < len) { // reversal up
                res[row--].append(c[i++]);
            }
        }
        for (int i = 1; i < numRows; i++) {
            res[0].append(res[i]);
        }
        return res[0].toString();
    }
}
