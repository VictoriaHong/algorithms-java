// Roman to Integer
public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int i = s.length() - 2;
        int res = map.get(s.charAt( i + 1));
        while (i >= 0) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                res += map.get(s.charAt(i));
            }
            else {
                res -= map.get(s.charAt(i));
            }
            i--;
        }
        return res;
    }
}
