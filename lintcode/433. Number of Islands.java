public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // 使用BFS
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int columns = grid[0].length;
        int number = 0;
        boolean[][] isUsed = new boolean[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] && isUsed[i][j] == false) {
                    number++;
                    bfs(grid, i, j, isUsed);
                }
            }
        }
        return number;
    }

    private void bfs(boolean[][] grid, int i, int j, boolean[][] isUsed) {
        int[] dx = new int[] { 0, 0, 1, -1 };
        int[] dy = new int[] { 1, -1, 0, 0 };
        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();
        queueX.offer(i);
        queueY.offer(j);
        isUsed[i][j] = true;

        while (!queueX.isEmpty()) {
            int curX = queueX.poll();
            int curY = queueY.poll();

            for (int k = 0; k < 4; k++) {
                int nx = curX + dx[k];
                int ny = curY + dy[k];
                if (check(grid, nx, ny, isUsed)) {
                    queueX.offer(nx);
                    queueY.offer(ny);
                    isUsed[nx][ny] = true;
                }
            }
        }
    }

    private boolean check(boolean[][] grid, int nx, int ny, boolean[][] isUsed) {
        int rows = grid.length;
        int columns = grid[0].length;
        if (nx >= 0 && nx < rows && ny >= 0 && ny < columns && grid[nx][ny] && isUsed[nx][ny] == false) {
            return true;
        }
        return false;
    }
}