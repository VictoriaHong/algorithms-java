// t: O(n)
public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        int root = 2;
        while (root <= num/root) {
            if (root * root == num) return true;
            root++;
        }
        return false;
}

// t: O(lgn)
public class Solution {
    public boolean isPerfectSquare(int num) {
        int lo = 1;
        int hi = num;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            int res = num / mid;
            if(mid == res) return num % mid == 0;
            else if (mid > res) hi = mid - 1;
            else lo = mid + 1;
        }
        return false;
    }
}
