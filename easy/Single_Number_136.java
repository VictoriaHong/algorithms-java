// Single Number
public class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) set.remove(i);
            else set.add(i);
        }
        return set.iterator().next();
    }
}
