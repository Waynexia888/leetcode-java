public class Solution {
    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        int[] arr = new int[A.length + B.length];
        int index = 0;
        int indexA = 0;
        int indexB = 0;
        while (indexA < A.length && indexB < B.length) {
            if (A[indexA] < B[indexB]) {
                arr[index] = A[indexA];
                index++;
                indexA++;
            } else {
                arr[index] = B[indexB];
                index++;
                indexB++;
            }
        }

        while (indexA < A.length) {
            arr[index++] = A[indexA++];
        }

        while (indexB < B.length) {
            arr[index++] = B[indexB++];
        }
        return arr;
    }
}