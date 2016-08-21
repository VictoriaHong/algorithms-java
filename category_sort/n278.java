// t: O(lgn)
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            boolean res = isBadVersion(mid);
            if (!res) lo = mid + 1;
            else hi = mid - 1;
        }
        
        return lo;
    }
}

// F F F F F T T T T
// return hi is end of F; return lo is begin of T 

// same
while (lo <= hi) {
    int mid = lo + (hi - lo)/2;
    boolean res = SVNRepo.isBadVersion(mid);
    if (res) hi = mid - 1;
    else lo = mid + 1;
}
        
return lo;
