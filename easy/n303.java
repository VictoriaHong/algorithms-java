// Range Sum Query - Immutable
public class NumArray {
    int[] presum;
    public NumArray(int[] nums) {
        int n = nums.length;
        presum = new int[n + 1];
        for(int i = 0; i < n; i++) {
            presum[i + 1] = presum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return presum[j + 1] - presum[i];
    }
}
