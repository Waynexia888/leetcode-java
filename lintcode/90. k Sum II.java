public class Solution {
    /**
     * @param A: an integer array
     * @param k: a postive integer <= length(A)
     * @param targer: an integer
     * @return: A list of lists of integer
     */
    public List<List<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (A == null || A.length == 0) {
            return results;
        }

        Arrays.sort(A);
        List<Integer> temp = new ArrayList<>();
        dfs(A, k, target, 0, temp, results);
        return results;
    }

    private void dfs(int[] A, int k, int remainingTarget, int startIndex, 
                        List<Integer> temp, List<List<Integer>> results) {
     
        if (k == 0 && remainingTarget == 0) {
            results.add(new ArrayList<Integer>(temp));
        }

        if (k == 0 || remainingTarget <= 0) {
            return;
        }

        for (int i = startIndex; i < A.length; i++) {
            temp.add(A[i]);
            dfs(A, k - 1, remainingTarget - A[i], i + 1, temp, results);
            temp.remove(temp.size() - 1);
        }
    }
}