// Longest Substring with At Most Two Distinct Characters
// two chasing pointers t: O(n)
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        return lengthOfLongestSubstringKDistinct(s, 2);
    }
    
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


// without map
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char[] ss = s.toCharArray();
        int first = 0, latestFirst = -1;
        int maxLen = 0;
        for (int k = 1; k < ss.length; k++) {
            if (ss[k] == ss[k-1]) continue;
            if (latestFirst > -1 && ss[k] != ss[latestFirst]) { // 3rd letter comes
                maxLen = Math.max(maxLen, k - first);
                first = latestFirst + 1; // first points to beginning of a new substring
            }
            // latestFirst == -1 || ss[k] != ss[k - 1] && ss[k] == ss[latestFirst]
            // ss[first -> latestFirst] have at most 2 distict characters
            latestFirst = k - 1;
        }
        return maxLen > (ss.length - first) ? maxLen : ss.length - first;
    }
}
