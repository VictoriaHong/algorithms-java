// Largest Divisible Subset
// dp t: O(n^2)
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        int n = nums.length;
        int[] count = new int[n];
        int[] pre = new int[n];
        int max = 1;
        int index = 0;
        for (int i = 0; i < n; i++) {
            count[i] = 1;
            pre[i] = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (count[j] + 1 > count[i]) {
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if (count[i] > max) {
                max = count[i];
                index = i;
            }
        }
        while (index >= 0) {
            res.add(nums[index]);
            index = pre[index];
        }
        return res;
    }
}
