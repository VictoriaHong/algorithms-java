// Integer Replacement
public class Solution {
    public int integerReplacement(int n) {
        if (n == 1) return 0;
        if (n % 2 == 0) return integerReplacement(n / 2) + 1;
        else return (n == Integer.MAX_VALUE) ?
                     integerReplacement(n - 1) :
                     (Math.min(integerReplacement(n + 1), integerReplacement(n - 1)) + 1);
    }
}
