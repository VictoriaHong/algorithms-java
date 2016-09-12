// Number of 1 Bits
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }
}
/*
>>> is the logical (or unsigned) right shift operator.
>> is the arithmetic (or signed) right shift operator.
<< is the left shift operator, and meets the needs of both logical and arithmetic shifts.
*/
