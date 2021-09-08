Lintcode 677 · Number of Big Islands

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    /**
     * @param grid: a 2d boolean array
     * @param k: an integer
     * @return: the number of Islands
     */
    public int numsofIsland(boolean[][] grid, int k) {
        // Write your code here
        int rows = grid.length;
        int columns = grid[0].length;
        if (grid == null || rows == 0 || grid[0] == null || columns == 0) {
            return 0;
        }

        boolean[][] visited = new boolean[rows][columns];
        int numberOfIslands = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] && !visited[i][j]) {
                    int size = bfs(grid, i, j, visited);
                    if (size >= k) {
                        numberOfIslands++;
                    }
                }
            } 
        }
        return numberOfIslands;
    }

    private int bfs(boolean[][] grid, int x, int y, boolean[][] visited) {
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        int size = 1;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
                if (isValid(grid, nx, ny, visited)) { // within the board, is 1, not visited
                    size++;
                    queue.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
        return size;
    }

    private boolean isValid(boolean[][] grid, int nx, int ny, boolean[][] visited) {
        int rows = grid.length;
        int columns = grid[0].length;
        if (nx >= 0 && nx < rows && ny >= 0 && ny < columns && grid[nx][ny] && !visited[nx][ny]) {
            return true;
        }
        return false;
    }
}

// traverse the matrix, 
//     if grid[i][j] == 1, using bfs to search all adjacent 1, and count the size of this island
//         if the size of this island >= k, count++;
    
