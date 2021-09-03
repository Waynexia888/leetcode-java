Leetcode 57. Insert Interval

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> results = new ArrayList<>();
        
        // from left to right, find the right position to insert or merge
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            results.add(intervals[i]);
            i++;
        }
        
        int mergeStart = newInterval[0];
        int mergeEnd = newInterval[1];
        while (i < intervals.length && intervals[i][0] <= mergeEnd) {
            mergeStart = Math.min(mergeStart, intervals[i][0]);
            mergeEnd = Math.max(mergeEnd, intervals[i][1]);
            i++;
        }
        results.add(new int[]{mergeStart, mergeEnd});
        
        while (i < intervals.length) {
            results.add(intervals[i]);
            i++;
        }
        return results.toArray(new int[results.size()][]);
    }
}

//////////////////////////////////////////////////////////////////////
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> results = new ArrayList<>();
        
        List<int[]> list = new ArrayList<>();
        for (int[] arr : intervals) {
            list.add(arr);
        }
        list.add(newInterval);
        
        Collections.sort(list, (a, b) -> (a[0] - b[0]));
        
        int[] current = list.get(0);
        for (int[] next : list) {
            if (current[1] >= next[0]) { //overlapping
                current[0] = Math.min(current[0], next[0]);
                current[1] = Math.max(current[1], next[1]);
            } else {
                results.add(current);
                current = next;
            }
        }
        results.add(current);
        return results.toArray(new int[results.size()][]);
    }
}
