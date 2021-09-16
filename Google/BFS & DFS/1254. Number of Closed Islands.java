Leetcode 1254. Number of Closed Islands

class Solution {
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        
        int number = 0;
        boolean[][] visited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 0) {
                    if (dfs(grid, i, j)) {
                        number++;
                    }
                }
            }
        }
        return number;
    }
    
    private boolean dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false;
        }
        
//         if (visited[x][y]) {
//             return false;
//         }
        
//         visited[x][y] = true;
        
        if (grid[x][y] == 1) {
            return true;
        }
        grid[x][y] = 1;
        
        for (int[] dir : directions) {
            boolean ans = dfs(grid, x + dir[0], y + dir[1]);
            if (ans == false) {
                return false;
            }
        }
        return true;     
    }
}

////////////////////////////////////////////////////////////
class Solution {
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        
        int number = 0;
        boolean[][] visited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    if (bfs(grid, i, j, visited)) {
                        number++;
                    }
                }
            }
        }
        return number;
    }
    
    private boolean bfs(int[][] grid, int x, int y, boolean[][] visited) {
        int rows = grid.length;
        int columns = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        
        boolean res = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == 0 || cur[0] == rows - 1 || cur[1] == 0 || cur[1] == columns - 1) {
                res = false; //不能break，需要找出连通分量
            }
            
            for (int[] dir : directions) {
                int nx = cur[0] + dir[0];
                int ny = cur[1] + dir[1];
                if (isValid(grid, nx, ny, visited)) { // within the grid, == 0, not visited
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return res;
    }
    
    private boolean isValid(int[][] grid, int x, int y, boolean[][] visited) {
        int rows = grid.length;
        int columns = grid[0].length;
        if (x < 0 || x >= rows || y < 0 || y >= columns) {
            return false;
        }
        if (grid[x][y] != 0) {
            return false;
        }
        if (visited[x][y]) {
            return false;
        }
        return true;
    }
    

}
// BFS搜索每一个岛屿(即0)， 找出该岛屿的连通分量，同时对该岛屿（以及其连通分量）进行判断，如果该岛屿处在边缘，则不能被水域包围

////////////////////////////////////////////////////////////////////
class Solution {
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean isClosed = true;
    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        
        int number = 0;
        boolean[][] visited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    isClosed = true;
                    dfs(grid, i, j, visited);
                    if (isClosed) {
                        number++;
                    }
                }
            }
        }
        return number;
    }
    
    private void dfs(int[][] grid, int x, int y, boolean[][] visited) {
        int rows = grid.length;
        int columns = grid[0].length;
        
        if (x < 0 || x >= rows || y < 0 || y >= columns) {
            isClosed = false;
            return;
        }
     
        if (visited[x][y] || grid[x][y] != 0) {
            return;
        }
        visited[x][y] = true;
        for (int[] dir : directions) {
            dfs(grid, x + dir[0], y + dir[1], visited);
        }
    }
}
// DFS搜索每一个岛屿(即0)， 找出该岛屿的连通分量，同时对该岛屿（以及其连通分量）进行判断，如果该岛屿处在边缘，则不能被水域包围

/////////////////////////////

class Solution {
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        
        int number = 0;
        boolean[][] visited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    if (dfs(grid, i, j, visited)) {
                        number++;
                    }
                }
            }
        }
        return number;
    }
    
    private boolean dfs(int[][] grid, int x, int y, boolean[][] visited) {
        int rows = grid.length;
        int columns = grid[0].length;
        
        if (x < 0 || x >= rows || y < 0 || y >= columns) {
            return false;
        }
     
        if (visited[x][y] || grid[x][y] != 0) {
            // 不知道该return啥，也不能break
        }
        visited[x][y] = true;
        for (int[] dir : directions) {
            boolean ans = dfs(grid, x + dir[0], y + dir[1], visited);
            if (ans == false) {
                return false;
            }
        }
        return true;
    }
}
// DFS搜索每一个岛屿(即0)， 找出该岛屿的连通分量，同时对该岛屿（以及其连通分量）进行判断，如果该岛屿处在边缘，则不能被水域包围