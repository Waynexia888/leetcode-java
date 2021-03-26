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

////////////////////////////////////////////////////////
public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // DFS 
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int[][] DIRECTIONS = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };
        
        int rows = grid.length;
        int columns = grid[0].length;
        boolean[][] visited = new boolean[rows][columns];
        
        int numberOfIsland = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (check(grid, i, j, visited)) {
                    dfs(grid, i, j, visited, DIRECTIONS);
                    numberOfIsland++;
                }
            }
        }
        return numberOfIsland;
    }
    
    private void dfs(boolean[][] grid, int x, int y, boolean[][] visited, int[][] DIRECTIONS) {
        visited[x][y] = true;
        for (int k = 0; k < 4; k++) {
            int nx = x + DIRECTIONS[k][0];
            int ny = y + DIRECTIONS[k][1];
            if (check(grid, nx, ny, visited)) {
                dfs(grid, nx, ny, visited, DIRECTIONS);
            }
        }
    }
    
    private boolean check(boolean[][] grid, int x, int y, boolean[][] visited) {
        int rows = grid.length;
        int columns = grid[0].length;
        if (x >= 0 && x < rows && y >= 0 && y < columns && grid[x][y] && !visited[x][y]) {
            return true;
        }
        return false;
    }
}

////////////////////////////////////////////////////////////
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
        // 遍历这个二维矩阵
        //     如果这个点为岛屿，且没有被访问过
        //         从这个点开始bfs，找到相邻的所有的岛屿，然后把它们标记访问过
        // 返回大岛屿的数量

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int columns = grid[0].length;
        int number = 0;
        boolean[][] visited = new boolean[rows][columns]; 
        

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] && visited[i][j] == false) {
                    number++;
                    bfs(grid, i, j, visited);
                }
            }
        }
        return number;
    }

    private void bfs(boolean[][] grid, int i, int j, boolean[][] visited) {
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = point.x + dx[k];
                int ny = point.y + dy[k];
                if (isValid(grid, nx, ny, visited)) {
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    private boolean isValid(boolean[][] grid, int nx, int ny, boolean[][] visited) {
        // 判断（nx, ny)是否在矩阵里，是否是一个岛屿， 没有被访问过
        int rows = grid.length;
        int columns = grid[0].length;
        if (nx < 0 || nx >= rows || ny < 0 || ny >= columns) {
            return false;
        }
        if (!grid[nx][ny]) {
            return false;
        }
        if (visited[nx][ny] == true) {
            return false;
        }
        return true;
    }
}

/////////////////////////////////////////////////////////////////
public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public static int[] dx = new int[]{0, 0, -1, 1};
    public static int[] dy = new int[]{1, -1, 0, 0};
    public int numIslands(boolean[][] grid) {
        // 找到一个小岛(x, y)
        // 将当前点放入访问数组visited中
        // 深度搜索(x, y)的周围节点
        //      检查周围点的有效性（是否在矩阵中， 为1， 之前没被访问过）
        //          对有效点进行dfs递归搜索

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int columns = grid[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int number = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    number++;
                }
            }
        }
        return number;
    }

    private void dfs(boolean[][] grid, int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        int rows = grid.length;
        int columns = grid[0].length;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < rows && ny >= 0 && ny < columns && grid[nx][ny] && !visited[nx][ny]) {
                dfs(grid, nx, ny, visited);
            }
        }
    }
}
