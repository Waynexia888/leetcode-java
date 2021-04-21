public class Solution {
    /**
     * @param A: an integer array sorted in ascending order
     * @param target: An integer
     * @return: an integer
     */
    public int closestNumber(int[] A, int target) {
        // time: O(logn); space: O(1)
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int middle = start + (end - start) / 2;
            // find the first position >= target
            if (A[middle] < target) {
                start = middle;
            } else {
                end = middle;
            }
        }

        if ((target - A[start]) < (A[end] - target)) {
            return start;
        } 
        return end; 
    }
}