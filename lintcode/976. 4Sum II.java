public class Solution {
    /**
     * @param A: a list
     * @param B: a list
     * @param C: a list
     * @param D: a list
     * @return: how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        
        for (int k = 0; k < C.length; k++) {
            for (int l = 0; l < D.length; l++) {
                int sum = C[k] + D[l];
                result += map.getOrDefault(-sum, 0);
            }
        }
        return result;
    }
}

// A[i] + B[j] = -(C[k] + D[l])
// key: A[i] + B[j]
// value: count