public class Solution {
    /**
     * @param grid: a 2d boolean array
     * @param k:    an integer
     * @return: the number of Islands
     */
    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int[][] DIRECTIONS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int numsofIsland(boolean[][] grid, int k) {
        // 1. 从为1的地方开始bfs
        // 2. 在bfs的过程中，记录经过的岛屿规模，返回岛屿规模
        // 3. 判断岛屿规模是否大于k
        // time: O(m * n), space: O(m * n)

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length; // 行
        int n = grid[0].length; // 列
        boolean[][] visited = new boolean[m][n];
        int islands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] && !visited[i][j]) {
                    int size = bfs(grid, visited, i, j);
                    if (size >= k) {
                        islands++;
                    }
                }
            }
        }
        return islands;
    }

    private int bfs(boolean[][] grid, boolean[][] visited, int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = point.x + DIRECTIONS[k][0];
                int ny = point.y + DIRECTIONS[k][1];
                if (isValid(grid, visited, nx, ny)) {
                    queue.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isValid(boolean[][] grid, boolean[][] visited, int nx, int ny) {
        int m = grid.length; // 行
        int n = grid[0].length; // 列
        if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] && !visited[nx][ny]) {
            return true;
        }
        return false;
    }
}