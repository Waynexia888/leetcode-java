public class Solution {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: An integer
     */
    public int searchInsert(int[] A, int target) {
        // sorted array and target, so use binary search
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {                  // 结束的时候是一个[1, 3]， length = 2 的数组
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (A[start] >= target) {
            return start;
        }
        
        if (A[end] >= target) {
            return end;
        }
        return end + 1;  //     如果target比数组中所有的数都大， return end + 1;
    }
}