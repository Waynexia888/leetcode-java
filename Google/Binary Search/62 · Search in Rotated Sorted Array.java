Lintcode 62 · Search in Rotated Sorted Array

public class Solution {
    /**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > A[0]) {  // 说明这一段是一个上升区间
                if (target >= A[0] && target <= A[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else { // A[mid] <= A[0]
                if (target >= A[mid] && target <= A[A.length - 1]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }

        if (A[start] == target) {
            return start;
        }
        if (A[end] == target) {
            return end;
        }
        return -1;
    }
}