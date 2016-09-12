// Sum of Two Integers
public class Solution {
    public int getSum(int a, int b) {
        int res = a ^ b; // 0 + 0 = 0; 1 + 0 = 0 + 1 = 1; 1 + 1 = 0
        int carry = (a & b) << 1; // 0 + 0和1 + 0的位置与完为0, 1 + 1位有进位, 相当于左移一位
        if (carry != 0) {
            return getSum(res, carry);
        }
        return res;
    }
}
