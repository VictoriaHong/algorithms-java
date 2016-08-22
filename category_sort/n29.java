//
public class Solution {
    public int divide(int dividend, int divisor) {
    if (divisor == 1) {
            return dividend;
        }
        int sign = 1;
        if (dividend > 0) {
            dividend = -dividend;
            sign = -1;
        }
        if (divisor > 0) {
            divisor = -divisor;
            sign = sign == -1 ? 1 : -1;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int res = 0;
        while (dividend <= divisor) { // dividend, divisor < 0
            int crt = divisor;
            int multiplier = 1;
            while (crt > dividend - crt) { // find the bigest divisor
                crt = crt << 1;
                multiplier = multiplier << 1;
            }
            dividend -= crt;
            res += multiplier;
        }
        return sign * res;
    }
}
