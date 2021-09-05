Lintcode 183 · Wood Cut

public class Solution {
    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if (L == null || L.length == 0) {
            return 0;
        }

        int start = 1, end = 0;
        for (int len : L) {
            end = Math.max(end, len);
        }

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (countWood(L, mid) >= k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (countWood(L, end) >= k) {
            return end;
        }
        if (countWood(L, start) >= k) {
            return start;
        }
        return 0;
    }

    private int countWood(int[] L, int len) {
        int count = 0;
        for (int woodLength : L) {
            count += woodLength / len;
        }
        return count;
    }
}
