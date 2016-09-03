// Increasing Triplet Subsequence
// O(n)
// if update smallest, means nums keep getting smaller
// if update small, means there is a smallest element with smaller index before this new small with larger index
// once a num greater than small appears, means we find the third larger element with larger index
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        
        int smallest = Integer.MAX_VALUE;
        int small = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i <= smallest) smallest = i;
            else if (i <= small) small = i;
            else return true;
        }
        return false;
    }
}
