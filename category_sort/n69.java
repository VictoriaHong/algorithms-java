// Newton's Method X(n+1)=1/2(X(n)+S/X(n))
public class Solution {
    public int mySqrt(int x) {
        if (x == 1)
            return 1;
        float y = 1;
        float old = 0;
        while ((int) (old - y) != 0) { // not very accurate
            old = y;
            y = (y + x * 1.0f / y) * 0.5f;  //Iterative Convergence
        }
        int res = (int) y;
        return res * res > x ? res - 1 : res;//accommodate the Q
    }
}
