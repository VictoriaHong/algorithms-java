// Word Pattern
public class Solution {
    private String[] words;
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || pattern.length() == 0 || str == null || str.length() == 0) return false;
        words = str.split(" ");
        if (pattern.length() != words.length) return false;
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            if(!map.containsKey(pattern.charAt(i))) {
                map.put(pattern.charAt(i), words[i]);
                if (set.contains(words[i])) return false;
                set.add(words[i]);
            }
            else {
                String tmp = map.get(pattern.charAt(i));
                if (!tmp.equals(words[i])) return false;
            }
        }
        return true;
    }
}
