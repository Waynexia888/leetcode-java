public class Solution {
    /**
     * @param A: the given array
     * @return: the minimum sum of a falling path
     */
    public int minFallingPathSum(int[][] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }

        // state: dp[i][j]: 以当前位置(i, j)结尾的最小路径和
        int m = A.length;
        int[][] dp = new int[m][m];
        // initialization: 第一行的任何一个位置的值都是原数组本身对应的值
        // 第一列 和 最后一列的任何一个位置只能从两个方向过来
        for (int i = 0; i < m; i++) {
            dp[0][i] = A[0][i];
        }

        // function: dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i - 1][j + 1]) + A[i][j]
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + A[i][j];
                    continue;
                }

                if (j == m - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + A[i][j];
                    continue;
                }
                dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1])) + A[i][j];
            }
        }

        // answer: min(m - 1)
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            result = Math.min(result, dp[m - 1][i]);
        }
        return result;
    }
}