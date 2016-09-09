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

/*
解题思路：
1. longest 想到要有 global max 和 curlen
2. no repeating 可以用 set/map解决

方法一：enumerate all possible substrings

for (i = 0 -> n)
    for (j = i -> n)
        for (k = 0 -> j)
            have dup then break

time: O(n^3)

方法二：move j and update set，利用与前一位的关系，重复利用set

for (i = 0 -> n)
    new set
    for (j = i -> n)
        set.add当前位，看有没有重复，重复就break

time: O(n^2)

方法三：move i as far as possible，减少一些结果已知的substring

例如：abcabcbb
i = 0 j = 0 N
i = 0 j = 1 N  i = 1 j = 1 N (substring少一位更不会重复)
i = 0 j = 2 N  i = 1 j = 2 N  i = 2 j = 2 N
i = 0 j = 3 Y  i = 1 j = 3 ?  j = 2 j = 3 ?  i = 3 j = 3 ?
所以j移动到重复位停止不动，i移动一步跟重复位比较一次，直到等于重复位，继续移动j
*/
