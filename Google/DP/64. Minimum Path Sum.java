Leetcode 64. Minimum Path Sum

class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        
        // state: dp[i][j]: the minimim sum from top left (0, 0) to current position (i, j)
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];   
        
        // initialization: 
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        
        // dp[i][j] = Math,min(dp[i - 1][j] + dp[i][j - 1]) + grid[i][j]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        
        // answer:
        return dp[m - 1][n - 1];
        
    }
}

// last step: (m - 1, n - 1) <- (m - 2, n - 1), (m - 1, n - 2)
// state: dp[i][j]: the minimim sum from top left (0, 0) to current position (i, j)
// dp[i][j] = Math,min(dp[i - 1][j] + dp[i][j - 1]) + grid[i][j]
// initialization: 
    // dp[0][0] = grid[0][0];
    // first row: dp[0][j] = dp[0][j - 1] + grid[0][j]
    // first column: dp[i][0] = dp[i - 1][0] + grid[i][0]
// Answer: dp[m - 1][n - 1]

////////////////////////////////////////////////////////////////////////////
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        
        // state: dp[i][j]: the minimim sum from top left (0, 0) to current position (i, j)
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];   
        
        // initialization: (this part can be written in the body)
        
        // dp[i][j] = Math,min(dp[i - 1][j] + dp[i][j - 1]) + grid[i][j]
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                    continue;
                }
                
                int sum = Integer.MAX_VALUE;
                if (i > 0) {
                    sum = Math.min(sum, dp[i - 1][j]);
                }
                if (j > 0) {
                    sum = Math.min(sum, dp[i][j - 1]);
                }
                dp[i][j] = sum + grid[i][j];
            }
        }
        
        // answer:
        return dp[m - 1][n - 1];
        
    }
}
