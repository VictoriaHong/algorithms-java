// Factorial Trailing Zeroes
public class Solution {
    public int trailingZeroes(int n) {
        // n = 1 -- 5 -- 10 -- 15 -- 20 -- 25 -- 30 -- 35
        // 0   0 -- 1 -- 2  -- 3  -- 4  -- 6  -- 7  -- 8
        int res = 0;
        while (n > 0) {
            res += n/5;
            n /= 5;
        }
        return res;
    }
}
