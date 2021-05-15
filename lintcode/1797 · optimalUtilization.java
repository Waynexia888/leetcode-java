public class Solution {
    /**
     * @param A: a integer sorted array
     * @param B: a integer sorted array
     * @param K: a integer
     * @return: return a pair of index
     */
    public int[] optimalUtilization(int[] A, int[] B, int K) {
        // time: O(m * n); space: O(1)
        if (A == null || A.length == 0 || B == null || B.length == 0) {
            return new int[0];
        }

        int indexA = 0, indexB = 0;
        int currentSum = A[indexA] + B[indexB];
        if (currentSum > K) {
            return new int[0];
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] + B[j] == K) {
                    return new int[]{i, j};
                } else if (A[i] + B[j] < K) {
                    if (A[i] + B[j] > currentSum) {
                        indexA = i;
                        indexB = j;
                        currentSum = A[indexA] + B[indexB];
                    }
                } else { // A[i] + B[j] > K
                    break;
                }
            }
        }

       return new int[]{indexA, indexB};
    }
}

// A = [1, 4, 6, 9], B = [1, 2, 3, 4], K = 9
//            i                 j

// 1 + 4 < 9 i++
// 4 + 4 < 9 i++
// 6 + 4 > 9 j--
// 6 + 3 = 9 return


// A = [1, 4, 6, 8], B = [1, 2, 3, 5], K = 12
//               i              j

// 1 + 5 < 12 i++
// 4 + 5 < 12 i++
// 6 + 5 < 12 i++ 记录一下currentSum，以及下标i， j
// 8 + 5 > 12 j--
// 8 + 3 < 12 跟前面的currentSum比较一下
