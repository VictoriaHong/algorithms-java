// Palindrome Number
// negative integers are not  palindromes
public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int compare = 0;
        int div = x;
        while (div != 0) {
            compare = compare * 10 + div % 10;
            div /= 10;
        }
        return compare == x;
    }
}
