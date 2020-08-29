// Given an array of meeting time intervals consisting of start and end times 
// [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

// Example 1:

// Input: [[0, 30],[5, 10],[15, 20]]
// Output: 2
// Example 2:

// Input: [[7,10],[2,4]]
// Output: 1


class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // 以start作为扫描线。从左往右扫描
        // 1. 创建数组来记录所有的starts扫描点，以及ends结束的交点
        // 2. 对starts，以及ends进行排序
        // 3. 从左往右扫描
        // time: O(nlogn), space: O(n)
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int results = 0;
        int end = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (starts[i] < ends[end]) {
                results++;
            } else {
                end++;
            }
        }
        return results; 
    }
}

// 本题使用sweep line扫描线的算法思想
// 把一个区间的start当作扫描线， 把一个区间的end当作交点，从左往右扫描