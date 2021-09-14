Leetcode 63. Unique Paths II

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        if (obstacleGrid[0] == null || obstacleGrid[0].length == 0) {
            return 0;
        }
        // state: dp[i][j]: number of ways that you can reach the currrent grid(i, j)
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        
        // initialization: 
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                dp[0][i] = 0;
                break;
            }
            dp[0][i] = 1;
        }
        
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
                break;
            }
            dp[i][0] = 1;
        }
        
        // function: dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = dp[i - 1][j]  + dp[i][j - 1];
            }
        }
        
        // answer:
        return dp[m - 1][n - 1];
    }
}

// last step: (i, j - 1) or (i - 1, j)
// state: dp[i][j]: number of ways that you can reach the current grid (i, j).
// function: dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
// initialization: (corner case)
//     if the grid[i][j] == 1, dp[i][j] = 0
//     if grid(0, 0) or grid(m - 1, n - 1) is obstacle, dp[0][0] = 0, dp[m - 1][n - 1] = 0
//     if first row, dp[i][j] = dp[i][j - 1]
//     if first column, dp[i][j] = dp[i - 1][j]
//     otherwise, dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
// Answer: dp[m - 1][n - 1]