// Longest Substring Without Repeating Characters
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = 0; // pos right after duplicate
        for (; i < n; i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                max = Math.max(max, i - j);
                while (s.charAt(j) != c) set.remove(s.charAt(j++)); // move j to dup
                j++; // move j to next to dup
            }
            else set.add(c);
        }
        max = Math.max(max, i - j); // no duplicates
        return max;
    }
}
