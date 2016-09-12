// Power of Two
// bit
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return (n < 1) ? false : (n & (n - 1)) == 0;
    }
}

// recursive
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n < 1) return false;
        if (n == 1 || n == 2) return true;
        return (n % 2 == 0) ? isPowerOfTwo(n/2) : false;
    }
}
