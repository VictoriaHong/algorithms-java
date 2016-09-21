// Reverse Bits
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i <= 31; i++)
            res = (res << 1 ) ^ ((n >>> i) & 1);
        return res;
    }
}
