/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        if (intervals == null || intervals.size() == 0) {
            return true;
        }
        
       Collections.sort(intervals, new Comparator<Interval>() {
           public int compare(Interval a, Interval b) {
               if (a.start == b.start) return a.end - b.end;
               return a.start - b.start;
           }
       });
        
        for (int i = 0; i < intervals.size() - 1; i++) {
            if (intervals.get(i).end > intervals.get(i + 1).start) {
                return false;
            }
            
            //cannot attend two meetings start at the same time
            if (intervals.get(i).start == intervals.get(i + 1).start) {
                return false; 
            }
        }
        return true;
    }
}