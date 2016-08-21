/**
 Because the range of H-index is [0,n], at the beginning we must point high pointer after the last element of the array: l = n. In this way we can generate all possible value without worrying about annoying corner case.
**/
public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if (n == 0) return 0;
        int lo = 0;
        int hi = n;
        while (lo < hi) { // lo <= hi may cause index out of boundary
            int mid = lo + (hi - lo)/2;
            if(n - mid == citations[mid]) return n - mid;
            else if (n - mid < citations[mid]) hi = mid; // think about [100]
            else lo = mid + 1; // think about [0]
        }
        return n - hi; // end with lo == hi
    }
}
