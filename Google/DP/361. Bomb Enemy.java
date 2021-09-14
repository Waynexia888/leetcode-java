Leetcode 361. Bomb Enemy

class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        
        // state: up[i][j]: the maximum enemies you can kill from the current position (i, j) to the up direction
        int m = grid.length, n = grid[0].length;
        int maxEnemies = 0;
        int[][] up = new int[m][n];
        int[][] down = new int[m][n];
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];
        
        // up[i][j] = up[i - 1][j] (if (i, j) is an empty) 
        //          or up[i - 1][j] + 1 (if (i, j) is an enemy)
        //          or 0 (if (i, j) is a wall)
        
        // up
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'W') {
                    up[i][j] = 0;
                    continue;
                }
                up[i][j] = grid[i][j] == 'E' ? 1 : 0;
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
                down[i][j] = grid[i][j] == 'E' ? 1 : 0;
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
                left[i][j] = grid[i][j] == 'E' ? 1 : 0;
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
                right[i][j] = grid[i][j] == 'E' ? 1 : 0;
                if (j < n - 1) {
                    right[i][j] += right[i][j + 1];
                }
            }
        }
        
        // sum
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    int sum = up[i][j] + down[i][j] + left[i][j] + right[i][j];
                    maxEnemies = Math.max(maxEnemies, sum);
                }
            }
        }
        return maxEnemies;
    }
}

// last step: current (i, j) = up (i - 1, j) 向上 + down (i + 1, j) 向下 
                                // + left (i, j - 1) 向左 + right (i, j + 1) 向右
// state: up[i][j]: the maximum enemies you can kill from the current position (i, j) to the up direction
        // down[i][j]
        // left[i][j]
        // right[i][j]
// function:
// up[i][j] = up[i - 1][j] (if (i, j) is an empty) 
//         or up[i - 1][j] + 1 (if (i, j) is an enemy)
//         or 0 (if (i, j) is a wall)
// initialization:
// up[i][j]; the first row -> up[0][j] = 0 (if (0, j) is an empty)
//                         -> up[0][j] = 1 (if (0, j) is an enemy)

// time: O(M*N); space: O(M * N)