// s: O(n) t: O(n)
public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = nums[i]+"";
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String i, String j) {
                String s1 = i+j;
                String s2 = j+i;
                return s2.compareTo(s1);
            }
        });
        if (strs[0].charAt(0) == '0') return "0";
        String res = new String();
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }
        return res;
    }
}
