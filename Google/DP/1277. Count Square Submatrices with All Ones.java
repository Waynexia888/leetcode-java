Leetcode 1277. Count Square Submatrices with All Ones

class Solution {
    public int countSquares(int[][] matrix) {
        // state: dp[i][j]: the size/edge of largest square submatrices ending at current position(x, y)
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        // initialization: the first row, first column
        
        // function: dp[i][j] = min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]) + 1;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    if (matrix[i][j] == 1) {
                        dp[i][j] = 1;
                    }
                } else {
                    if (matrix[i][j] == 1) {
                        dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    }
                }
                sum += dp[i][j];
            }
        }
        
        // answer: sum up every position(i, j)
        return sum;
    }
}

// time: O(MN); space: O(MN);