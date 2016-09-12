// Ugly Number
public class Solution {
    public boolean isUgly(int num) {
        if (num < 1) return false;

        num = divide(num, 2);
        num = divide(num, 3);
        num = divide(num, 5);
        
        return num == 1;
    }
    
    public int divide(int num, int prime) {
        while (num % prime == 0) {
            num /= prime;
        }
        return num;
    }
}
