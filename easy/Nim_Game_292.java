// Nim Game
public class Solution {
    public boolean canWinNim(int n) {
        // if (n == 0) return false;
        // if (n <= 3) return true;
        // if (!canWinNim(n - 1) || !canWinNim(n - 2) || !canWinNim(n - 3)) return true;
        // return false;
        return n % 4 != 0;
    }
}
