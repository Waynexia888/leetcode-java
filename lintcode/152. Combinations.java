public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (n == 0 || n < k) {
            return results;
        }
        List<Integer> temp = new ArrayList<>();
        dfs(n, k, 1, temp, results);
        return results;
    }

    private void dfs(int n, int k, int startIndex, List<Integer> temp, List<List<Integer>> results) {
        if (temp.size() == k) {
            results.add(new ArrayList<>(temp));
            return;
        }

        for (int i = startIndex; i <= n; i++) {
            temp.add(i);
            dfs(n, k, i + 1, temp, results);
            temp.remove(temp.size() - 1);
        }
    }
}