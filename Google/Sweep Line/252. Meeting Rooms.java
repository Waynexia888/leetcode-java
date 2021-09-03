Leetcode 252. Meeting Rooms

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        // time: O(nlogn); space: O(1)
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }
}