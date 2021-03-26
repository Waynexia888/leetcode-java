class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> results = new ArrayList<>();
        if (n < 2) {
            return results;
        }
        List<Integer> temp = new ArrayList<>();
        dfs(n, 2, temp, results);
        return results;
    }
    
    private void dfs(int n, int startIndex, List<Integer> temp, 
                     List<List<Integer>> results) {
        if (n == 1) {
            if (temp.size() > 1) {
                results.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            if (n % i != 0) {
                continue;
            }
            temp.add(i);
            dfs(n / i, i, temp, results);
            temp.remove(temp.size() - 1);
        }
    }
}