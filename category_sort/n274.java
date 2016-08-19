// s: O(1) t: O(nlgn)
// example:          0,1,4,5,6
// len - index:      5,4,3,2,1
// n values > x:     5,4,3,2,1
// target: find at least n values > n => find the first len - index <= x 
public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            if(citations.length - i <= citations[i]) return citations.length - i;
        }
        return 0;
    }
}

// s: O(n) t: O(n)
// if an author has N papers, then his/her h-index cannot be higher than N.
// That means we only need to have an array with size N + 1, the index of which records the number of citation.
// If the citation number > N, i.e, one of his 5 papers was referenced 100 times, then this credit goes to citation N.
// In the first pass, we can build the freq array with the number of papers in each citation bucket.
// Then the 2nd pass, we iterate from tail to head, add all the citations backwards until freq[i] >= i, then return i. 
public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int[] count = new int[len + 1];
        
        for (int c: citations)
            if (c > len) 
                count[len]++;
            else 
                count[c]++;     
        
        int total = 0;
        for (int i = len; i >= 0; i--) {
            total += count[i];
            if (total >= i)
                return i;
        }
        
        return 0;
    }
}

// binary search s:O(1) t: O(nlgn)
public class Solution {
    public int hIndex(int[] citations) {
        int lo = 0;
        int hi = citations.length; // considering num of citations > N
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo)/2;
            if(count(citations, mid) > mid) {
                lo = mid;
            }
            else if (count(citations, mid) < mid) {
                hi = mid;
            }
            else return mid;
        }
        
        if (count(citations, hi) == hi) return hi;
        else return lo;
    }
    
    public int count(int[] citations, int mid) {
        int count = 0; 
        for (int i: citations) {
            if (i >= mid) count++;
        }
        return count;
    }
}

// s: O(1) t: O(n) solution
// https://discuss.leetcode.com/topic/33102/o-n-time-o-1-space-solution
