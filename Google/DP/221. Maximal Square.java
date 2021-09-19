Leetcode 221. Maximal Square

class Solution {
    public int maximalSquare(char[][] matrix) {
        // state: dp[i][j]: the largest square edge containing only 1's ending at current position(i, j)
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        
        // initialization: first row, first column
    
        // function: dp[i][j] = min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]) + 1;
        int maxEdge = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    if (matrix[i][j] == '1') {
                        dp[i][j] = 1;
                    }
                } else {
                    if (matrix[i][j] == '1') {
                        dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                    }
                }
                maxEdge = Math.max(maxEdge, dp[i][j]);
            }
        }
        
        // answer: edge * edge
        return maxEdge * maxEdge;
    }
}