public class Solution {
    /**
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
        // f[i][j]为机器人有多少种方式从左上角走到(i, j)
        // 初始化：对于第一行 f[0][j]， 第一列 f[i][0]，前面都只可能有一条路径
        // 状态方程： f[i][j] = f[i - 1][j] + f[i][j - 1]
        // 时间复杂度: O(m * n); 空间复杂度: O(m * n)
        int[][] f = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    f[i][j] = 1;
                    continue;
                }
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }
}