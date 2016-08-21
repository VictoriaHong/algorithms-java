// s: O(1) t: O(nlgn + n)
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null) return false;
        
        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) return false;
        }
        
        return true;
    }
}
