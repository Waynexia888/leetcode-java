public class Solution {
    /**
     * @param A: a integer array 
     * @param B: a integer array
     * @return: return true or false
     */
    public boolean ArraySummarization(int[] A, int[] B) {
        // time: O(n^2); space: O(n)
        if (A == null || A.length < 2 || B == null || B.length == 0) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int n : B) {
            set.add(n);
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int sum = A[i] + A[j];
                if (set.contains(sum)) {
                    return true;
                }
            }
        }
        return false;
    }

}