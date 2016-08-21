// recursive t: O(lgn)
public class Solution {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1.0;
        if (n < 0) {
            x = 1/x;
            if (n == Integer.MIN_VALUE) {
                n = Integer.MAX_VALUE;
                x = Math.abs(x);
            }
            else n = -n;
        }
        if (n == 1) return x;
        double e = myPow(x*x, n/2);
        return n % 2 == 0? e : x * e;
    }
}

// iterative
public class Solution {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1.0;
        if (n < 0) {
            x = 1/x;
            if (n == Integer.MIN_VALUE) {
                n = Integer.MAX_VALUE;
                x = Math.abs(x);
            }
            else n = -n;
        }
        if (n == 1) return x;
        
        double res = 1;
        while(n > 0) {
            if (n % 2 != 0) res *= x;
            x *= x;
            n /= 2;
        }
        return res;
    }
}
