public class Solution {
    /**
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
        // 坐标型动态规划 - 自顶向下
        // state 状态; dp[i][j] 表示从0, 0 到i, j 的方案总数
        int[][] dp = new int[m][n];
        
        // 初始化initialize: 第0行第0列的前一步只能有一个方向过来
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        
        
        // 方程function: dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // 答案answer: dp[m - 1][n - 1]
        return dp[m - 1][n - 1];
    }
}