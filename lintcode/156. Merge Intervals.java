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
     * @param intervals: interval list.
     * @return: A new interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // 首先当然是对这个二维数组进行排序了
        // 那么排好序后，如何判断两个区间是否重叠呢？比如：a = [1, 4], b = [2, 3]
        // 当a[1] >= b[0], 说明两个区间有重叠， 那么如何把这个区间找出来呢？
        // 基于是排好序的，左边的位置一定是确定的，就是a[0], 而右边位置是max(a[1], b[1])
        // 随意我们就能找出该区间[1, 4]
        // leetcode 56题,要求返回的是int[][]， 但是一开始不知道合并后一共有多少个区间
        // 因此List<int[]> list = new ArrayList<>();
        // 当合并完所有重叠的部分后，需要将list转为int[][]；
        // int[][] result = new int[list.size()][2];
        // for (int i = 0; i < list.size() - 1; i++) {
        //     result[i] = list.get(i);    
        // }
        
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return result;
        }
        
        // 排序 
        intervals.sort(Comparator.comparing(i -> i.start));
        // leetcode: Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0])
        // System.out.println(intervals);
        
        // 打擂台的方式比较两个区间prev， current， 然后不断更新prev
        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            // 区间有交集
            if (prev.end >= current.start) {
                current.start = prev.start;
                current.end = Math.max(prev.end, current.end);
            } else {
                result.add(prev);
            }
            
            prev = current;
        }
        // for循环结束后，需要把最后一次更新的prev放入result的末尾
        result.add(prev);
        return result;
    }
}