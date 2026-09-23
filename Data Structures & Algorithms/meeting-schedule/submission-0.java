/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        //sort by start time,

        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        int end = -1;

        for (Interval interval : intervals) {
            if (interval.start < end) //overlap
                return false;
            end = Math.max(end, interval.end);
        }

        return true; 
    }
}
