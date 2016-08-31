// Reverse Words in a String
public class Solution {
    public String reverseWords(String s) {
        String[] ss = s.trim().split(" +");
        StringBuilder sb = new StringBuilder();
        for (int i = ss.length - 1; i >= 0; i--) {
            sb.append(ss[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
