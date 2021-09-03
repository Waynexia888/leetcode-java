Leetcode 56. Merge Intervals

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> results = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }
        
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        
        int[] current = intervals[0];
        for (int i = 0; i < intervals.length; i++) {
            int[] next = intervals[i];
            if (current[1] >= next[0]) { // overlapping
                current[0] = Math.min(current[0], next[0]);
                current[1] = Math.max(current[1], next[1]);
            } else { // no overlapping
                results.add(current);
                current = next;
            }  
        }
        results.add(current);
        
        // List<int[]> to int[][];
        return results.toArray(new int[results.size()][]);
    }
}
