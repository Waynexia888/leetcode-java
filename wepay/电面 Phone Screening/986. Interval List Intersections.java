class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        // time: O(min(m, n)); space: O(1)
        int p1 = 0, p2 = 0;
        int n1 = firstList.length, n2 = secondList.length;
        List<int[]> list = new ArrayList<>();
        
        while (p1 < n1 && p2 < n2) {
            int s1 = firstList[p1][0], e1 = firstList[p1][1];
            int s2 = secondList[p2][0], e2 = secondList[p2][1];
            int s = Math.max(s1, s2);
            int e = Math.min(e1, e2);
            if (s <= e) {  // 有交集
                list.add(new int[]{s, e});
            }
            
            // remove the interval with the smallest endpoint
            if (e1 > e2) {
                p2++;
            } else {
                p1++;
            }
        }
        return list.toArray(new int[][]{});
    }
}