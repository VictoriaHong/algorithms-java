// s: O(1) t: O(nlgn + n)
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0)
            return res;
            
        Collections.sort(intervals, new Comparator<Interval>(){
           @Override
           public int compare(Interval i1, Interval i2)
           {
               return i1.start - i2.start;
           }
        });
        
        Interval pre = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (cur.start <= pre.end) {
                pre.end = Math.max(pre.end, cur.end);
                continue;
            }
            else {
                res.add(pre);
                pre = cur;
            }
        }
        res.add(pre);
        
        return res;
    }
}
// https://discuss.leetcode.com/topic/36527/beat-98-48-6ms-java-solution-with-explanation
