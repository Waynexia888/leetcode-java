public class Merge_Sorted_Array {
    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * 
     * @param m: An integer
     * 
     * @param B: sorted integer array B which has n elements
     * 
     * @param n: An integer
     * 
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int index_A = m - 1, index_B = n - 1, insert_index = m - 1 + n;
        while (index_A >= 0 && index_B >= 0) {
            if (A[index_A] <= B[index_B]) {
                A[insert_index] = B[index_B];
                index_B -= 1;
            } else {
                A[insert_index] = A[index_A];
                index_A -= 1;
            }
            insert_index -= 1;
        }

        while (index_B >= 0) {
            A[insert_index--] = B[index_B--];
            // index_B -= 1;
            // insert_index -= 1;

        }

    }
}

//////////////////////////////////////////////////////////////////

public class Solution {
    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int index = m + n - 1;
        int indexA = m - 1;
        int indexB = n - 1;

        while (indexA >= 0 && indexB >= 0) {
            if (A[indexA] > B[indexB]) {
                A[index] = A[indexA];
                index--;
                indexA--;
            } else {
                A[index] = B[indexB];
                index--;
                indexB--;
            }
        }

        while (indexA >= 0) {
            A[index] = A[indexA];
            index--;
            indexA--;
        }

        while (indexB >= 0) {
            A[index] = B[indexB];
            index--;
            indexB--;
        }
        
    }
}

// 题目保证A的空间足够，如果从前往后一个一个插入，那么需要将后面的数字都挪动一位
// 那么我们可以从后往前插入即可，因为A的后面都是空的」