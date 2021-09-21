Leetcode 51. N-Queens

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        if (n == 0) {
            return results;
        }
        
        List<Integer> temp = new ArrayList<>();
        dfs(n, temp, results);
        return results;
    }
    
    private void dfs(int n, List<Integer> temp, List<List<String>> results) {
        if (temp.size() == n) {
            results.add(draw(temp));
            return;
        }
        
        // temp.get(i)表示第i行，第temp.get(i)列
        for (int i = 0; i < n; i++) {
            if (!isValid(temp, i)) {
                continue;
            }
            
            temp.add(i);
            dfs(n, temp, results);
            temp.remove(temp.size() - 1);
        }
    }
    
    private boolean isValid(List<Integer> temp, int col) {
        int row = temp.size();
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i) == col) {
                return false;
            }
            if (row + col == i + temp.get(i)) {
                return false;
            }
            if (row - col == i - temp.get(i)) {
                return false;
            }
        }
        return true;
    }
    
    private List<String> draw(List<Integer> temp) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < temp.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < temp.size(); j++) {
                sb.append(j == temp.get(i) ? 'Q' : '.');
            }
            result.add(sb.toString());
        }
        return result;
    }
}