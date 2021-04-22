public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // edge case
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid == null || m == 0 || n == 0) {
            return 0;
        }
        
        // coordinate type DP
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // if position i, j is an obstacle.
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                
                // after the previous if statement, the position i = 0, j = 0 will not be an obstacle
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                
                // first row (i = 0)
                dp[i][j] = 0;
                if (i == 0) {
                    dp[i][j] += dp[i][j - 1];
                }
                
                // first column (j = 0)
                if (j == 0) {
                    dp[i][j] += dp[i - 1][j];
                }
                
                // function dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; if i > 0 and j > 0;
                if (i > 0 && j > 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        // Answer:
        return dp[m - 1][n - 1];
    }
}

// time: O(m * n);
// space: O(m * n);