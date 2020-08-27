class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];
        int number = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    number++;
                    bfs(grid, visited, i, j);
                }
            }
        }
        return number;
    }
    
    private void bfs(char[][] grid, boolean[][] visited, int x, int y) {
        Queue<Integer> queueX = new LinkedList<>();
        queueX.offer(x);
        Queue<Integer> queueY = new LinkedList<>();
        queueY.offer(y);
        visited[x][y] = true;
        int[] dx = new int[] {0, 0, 1, -1};
        int[] dy = new int[] {1, -1, 0, 0};
        
        while (!queueX.isEmpty()) {
            int curX = queueX.poll();
            int curY = queueY.poll();
            
            for (int k = 0; k < 4; k++) {
                int nx = curX + dx[k];
                int ny = curY + dy[k];
                if (check(grid, visited, nx, ny)) {
                    queueX.offer(nx);
                    queueY.offer(ny);
                    visited[nx][ny] = true;
                }
            }
        }
    }
    
    private boolean check(char[][] grid, boolean[][] visited, int nx, int ny) {
        int m = grid.length;
        int n = grid[0].length;
        if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == '1' && !visited[nx][ny]) {
            return true;
        }
        return false;
    }
}