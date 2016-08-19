// s: O(n) t: O(n)
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        int pos = 0;
        
        for (Interval i : intervals) {
            if (i.end < newInterval.start) { // [i] [new]
                res.add(i);
                pos++;
            }
            else if (i.start > newInterval.end) { // [new] [i]
                res.add(i);
            }
            else { // overlap
                newInterval.start = Math.min(newInterval.start, i.start);
                newInterval.end = Math.max(newInterval.end, i.end);
            }
        }
        
        res.add(pos, newInterval);
        return res;
    }
}
