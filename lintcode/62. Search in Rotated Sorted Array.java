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
        
        int index = findMinIndex(A);
        if (A[index] <= target && target <= A[A.length - 1]) {
            return binarySearch(A, index, A.length - 1, target);
        }
        return binarySearch(A, 0, index - 1, target);
    }
    
    private int findMinIndex(int[] A) {
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < A[end]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (A[start] < A[end]) {
            return start;
        }
        return end;
    }
    
    private int binarySearch(int[] A, int start, int end, int target) {
        if (end < 0) {
            end += A.length;
        }
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] <= target) {
                start = mid;
            } else {
                end = mid;
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

time:O(logn); space: O(1)