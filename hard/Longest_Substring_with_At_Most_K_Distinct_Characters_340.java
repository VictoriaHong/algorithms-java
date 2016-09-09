//  Longest Substring with At Most K Distinct Characters
// two chasing pointers  t: O(n)
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) return 0;
        
        int i = 0;
        int j = 0;
        int max = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c) && map.size() < k) {
                map.put(c, 1);
            }
            else if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
            else {
                while (j <= i && map.size() >= k) { // move j to pos where dup < k
                    char tmp = s.charAt(j);
                    if (map.get(tmp) == 1) map.remove(tmp);
                    else map.put(tmp, map.get(tmp) - 1);
                    j++;
                }
                map.put(c, 1);
            }
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
