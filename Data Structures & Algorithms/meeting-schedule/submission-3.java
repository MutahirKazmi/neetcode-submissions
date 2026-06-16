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
    // 1. Sort by start time
    Collections.sort(intervals, Comparator.comparingInt(i -> i.start));
    
    // 2. Iterate through and compare current start with previous end
    for (int i = 1; i < intervals.size(); i++) {
        Interval prev = intervals.get(i - 1);
        Interval curr = intervals.get(i);
        
        // If current meeting starts before the previous one ends, it's a conflict
        if (curr.start < prev.end) {
            return false;
        }
    }
    
    return true;
}
}
