Leetcode 253. Meeting Rooms II

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        // sweep line, meeting start time mark as 1, end time mark as -1;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(new int[]{intervals[i][0], 1});
            list.add(new int[]{intervals[i][1], -1});
        }
        
        Collections.sort(list, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        
        int ans = 0, count = 0;
        for (int[] arr : list) {
            if (arr[1] == 1) {
                count++;
            } else {
                count--;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
