Lintcode 433 · Number of Islands

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int number = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] && !visited[i][j]) {
                    bfs(grid, i, j, visited);
                    number++;
                }
            }
        }
        return number;
    }

    private void bfs(boolean[][] grid, int i, int j, boolean[][] visited) {
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(i, j));
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = point.x + dx[k];
                int ny = point.y + dy[k];
                if (isValid(grid, nx, ny, visited)) { // within the board, == 1, never visited
                    queue.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    private boolean isValid(boolean[][] grid, int nx, int ny, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] && !visited[nx][ny]) {
            return true;
        }
        return false;
    }
}

// time: O(m * n); space: O(m * n)

////////////////////////////////////DFS//////////////////////////////

public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    private final int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int numIslands(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        
        int rows = grid.length, columns = grid[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int number = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] && !visited[i][j]) {
                    dfs(grid, i, j, visited, rows, columns);
                    number++;
                }
            }
        }
        return number;
    }

    private void dfs(boolean[][] grid, int x, int y, boolean[][] visited, int rows, int columns) {
        if (x < 0 || x >= rows || y < 0 || y >= columns || !grid[x][y] || visited[x][y]) {
            return;
        }

        visited[x][y] = true;
        // dfs(grid, x, y + 1, visited, rows, columns);
        // dfs(grid, x, y - 1, visited, rows, columns);
        // dfs(grid, x + 1, y, visited, rows, columns);
        // dfs(grid, x - 1, y, visited, rows, columns);
        for (int[] direction : directions) {
            dfs(grid, x + direction[0], y + direction[1], visited, rows, columns);
        }
    }

}