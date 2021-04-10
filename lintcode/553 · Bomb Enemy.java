public class Solution {
    /**
     * @param grid: Given a 2D grid, each cell is either 'W', 'E' or '0'
     * @return: an integer, the maximum enemies you can kill using one bomb
     */
    public int maxKilledEnemies(char[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n= grid[0].length;
        // up[i][j]代表从当前位置(i, j) 放一个炸弹，向上，最多可以炸死多少敌人
        int[][] up = new int[m][n];
        int[][] down = new int[m][n];
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];

        // up
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'W') {
                    up[i][j] = 0;
                    continue;
                }

                if (grid[i][j] == 'E') {
                    up[i][j] = 1;
                } else {
                    up[i][j] = 0;
                }

                if (i > 0) {
                    up[i][j] += up[i - 1][j];
                }
            }
        }

        // down
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'W') {
                    down[i][j] = 0;
                    continue;
                }

                if (grid[i][j] == 'E') {
                    down[i][j] = 1;
                } else {
                    down[i][j] = 0;
                }

                if (i < m - 1) {
                    down[i][j] += down[i + 1][j];
                }
            }
        }

        // left
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'W') {
                    left[i][j] = 0;
                    continue;
                }

                if (grid[i][j] == 'E') {
                    left[i][j] = 1;
                } else {
                    left[i][j] = 0;
                }

                if (j > 0) {
                    left[i][j] += left[i][j - 1];
                }
            }
        }

        // right
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 'W') {
                    right[i][j] = 0;
                    continue;
                }

                if (grid[i][j] == 'E') {
                    right[i][j] = 1;
                } else {
                    right[i][j] = 0;
                }

                if (j < n - 1) {
                    right[i][j] += right[i][j + 1];
                }
            }
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    int enemy = up[i][j] + down[i][j] + left[i][j] + right[i][j];
                    result = Math.max(result, enemy);
                }
            }
        }
        return result;
    }
}