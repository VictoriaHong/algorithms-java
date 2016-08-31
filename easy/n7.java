//
public class Solution {
    public int reverse(int x) {
        long rev = 0;
        while (x != 0) { // input x may smaller than 0
            rev = rev * 10 + x % 10;
            x = x/10;
            if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) return 0; // overflow
        }
        return (int)rev;
    }
}
