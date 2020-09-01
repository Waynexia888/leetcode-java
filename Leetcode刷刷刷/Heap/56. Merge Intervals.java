// Given a collection of intervals, merge all overlapping intervals.

// Example 1:

// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
// Example 2:

// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.


class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{};
        }
        
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> results = new ArrayList<>();
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                results.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        results.add(new int[]{start, end});
        return results.toArray(new int[][]{});
    }
}

// 本题思想： 全排序Arrays.sort() + lambda表达式
// 比较前一个区间的end && 后一个区间的start
// 要求返回的是int[][]， 但是一开始不知道合并后一共有多少个区间
// 因此List<int[]> list = new ArrayList<>();
// 当合并完所有重叠的部分后，需要将list转为int[][]；
// 即 results.toArray(new int[][]{});
// 时间复杂度: O(nlogn)
// 空间复杂度: O(n)