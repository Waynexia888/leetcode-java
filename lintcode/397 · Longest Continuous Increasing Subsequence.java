public class Solution {
    /**
     * @param A: An array of Integer
     * @return: an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // time: O(n); space: O(1)
        if (A == null || A.length == 0) {
            return 0;
        }

        int result = 1;
        int length = 1;
        // from left to right
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                length++;
                result = Math.max(result, length);
            } else {
                length = 1;
            }
        }

        // from right to left
        length = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                length++;
                result = Math.max(result, length);
            } else {
                length = 1;
            }
        }
        return result;
    }
}