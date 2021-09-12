Leetcode 695. Max Area of Island

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    private final int[] dx = new int[]{0, 0, 1, -1};
    private final int[] dy = new int[]{1, -1, 0, 0};
    
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length, columns = grid[0].length;
        if (grid == null || rows == 0 || grid[0] == null || columns == 0) {
            return 0;
        }
        
        int maxArea = 0;
        boolean[][] visited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int size = bfs(grid, i, j, visited);
                    maxArea = Math.max(maxArea, size);
                }
            }
        }
        return maxArea;
    }
    
    private int bfs(int[][] grid, int x, int y, boolean[][] visited) {
        int size = 1;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;
        
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
                if (isValid(grid, nx, ny, visited)) {
                    size++;
                    queue.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
        return size;
    }
    
    private boolean isValid(int[][] grid, int x, int y, boolean[][] visited) {
        int rows = grid.length, columns = grid[0].length;
        if (x < 0 || x >= rows || y < 0 || y >= columns) {
            return false;
        }
        if (visited[x][y]) {
            return false;
        }
        if (grid[x][y] != 1) {
            return false;
        }
        return true;
    }
}

////////////////////////   DFS //////////////////////////////////

class Solution {
    // private final int[] dx = new int[]{0, 0, 1, -1};
    // private final int[] dy = new int[]{1, -1, 0, 0};
    private final int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length, columns = grid[0].length;
        if (grid == null || rows == 0 || grid[0] == null || columns == 0) {
            return 0;
        }
        
        int maxArea = 0;
        boolean[][] visited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int size = dfs(grid, i, j, visited, rows, columns);
                    maxArea = Math.max(maxArea, size);
                }
            }
        }
        return maxArea;
    }
    
    private int dfs(int[][] grid, int x, int y, boolean[][] visited, int rows, int columns) {
        if (x < 0 || x >= rows || y < 0 || y >= columns || grid[x][y] != 1 || visited[x][y]) {
            return 0;
        }
        
        visited[x][y] = true;
        int size = 1;
        // size += dfs(grid, x, y + 1, visited, rows, columns);
        // size += dfs(grid, x, y - 1, visited, rows, columns);
        // size += dfs(grid, x + 1, y, visited, rows, columns);
        // size += dfs(grid, x - 1, y, visited, rows, columns);
        for (int[] direction : directions) {
            size += dfs(grid, x + direction[0], y + direction[1], visited, rows, columns);
        }
        return size;
    }

}