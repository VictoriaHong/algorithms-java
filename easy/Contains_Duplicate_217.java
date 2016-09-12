// Contains Duplicate
// hashmap
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        
        Set<Integer> distinct = new HashSet<Integer>();
        for(int num : nums) {
            if(distinct.contains(num)) {
                return true;
            }
            distinct.add(num);
        }
        return false;
    }
}

// sort
