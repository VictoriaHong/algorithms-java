// trap!!! the api says from the delar angle
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lo = 1;
        int hi = n;
        
        while(lo < hi) {
            int mid = lo + (hi - lo)/2;
            int res = guess(mid);
            if (res == -1) hi = mid - 1;
            else if (res == 1) lo = mid + 1;
            else return mid;
        }
        
        return lo;
    }
}
