Leetcode 52. N-Queens II

class Solution {
    private int count = 0;
    public int totalNQueens(int n) {
        if (n == 0) {
            return 0;
        }
        
        List<Integer> temp = new ArrayList<>();
        dfs(n, temp);
        return count;
    }
    
    private void dfs(int n, List<Integer> temp) {
        if (temp.size() == n) {
            count++;
            return;
        }
        
        // temp.get(i)表示第i行，第temp.get(i)列
        for (int i = 0; i < n; i++) {
            if (!isValid(temp, i)) {
                continue;
            }
            
            temp.add(i);
            dfs(n, temp);
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

}