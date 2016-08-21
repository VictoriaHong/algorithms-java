// 2 sum
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i <= nums.length; i++) {
            int find = target - nums[i];
            if (map.containsKey(find)) {
                int i2 = map.get(find);
                res[0] = i2;
                res[1] = i;
                return res;
            }
            else {
                map.put(nums[i], i);
            }
        }
        
        return res;
    }
}
