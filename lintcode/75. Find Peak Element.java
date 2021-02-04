public class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        int start = 1, end = A.length - 2;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // 上升趋势，所以peek在mid右边
            if (A[mid] < A[mid + 1]) {
                start = mid;
            // 下降趋势，所以peek在mid左边
            } else if (A[mid] < A[mid - 1]) {
                end = mid;
            } else {
                return mid;
            }
        }
        
        if (A[start] < A[end]) {
            return end;
        }
        return start;
    }
}
