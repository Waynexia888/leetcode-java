// Given an array of meeting time intervals consisting of start and end times 
// [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

// Example 1:

// Input: [[0,30],[5,10],[15,20]]
// Output: false
// Example 2:

// Input: [[7,10],[2,4]]
// Output: true


class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] > intervals[i][0]) {
                return false;
            }
        }
        return true;
    }
}

// 区间问题总结：
// 1. 按照start排序
// 2. 解题技巧：前一个区间的end && 后一个区间的start
// 时间复杂度 O(n), 空间复杂度O(1)
