/****************BFS*******/
class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y; 
    }
}
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0] == null || maze[0].length == 0) {
            return false;
        }
        
        int rows = maze.length;
        int columns = maze[0].length;
        boolean[][] visited = new boolean[rows][columns];
        
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(start[0], start[1]));
        visited[start[0]][start[1]] = true;
        
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (point.x == destination[0] && point.y == destination[1]) {
                return true;
            }
            for (int k = 0; k < 4; k++) {
                int nx = point.x + dx[k];
                int ny = point.y + dy[k];
                while (isValid(maze, nx, ny)) {
                    nx += dx[k];
                    ny += dy[k];
                }
                nx -= dx[k];
                ny -= dy[k];
                if (!visited[nx][ny]) {
                    queue.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
        return false;
    }
    
    private boolean isValid(int[][] maze, int nx, int ny) {
        int rows = maze.length;
        int columns = maze[0].length;
        if (nx >= 0 && nx < rows && ny >= 0 && ny < columns && maze[nx][ny] == 0) {
            return true;
        }
        return false;
    }
}

//////////带返回值的DFS///////////////////////////
class Solution {
    public static int[] dx = new int[]{0, 0, 1, -1};
    public static int[] dy = new int[]{1, -1, 0, 0};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0] == null || maze[0].length == 0) {
            return false;
        }
        
        int rows = maze.length;
        int columns = maze[0].length;
        boolean[][] visited = new boolean[rows][columns];
        visited[start[0]][start[1]] = true;
        return dfs(maze, start, destination, visited);   
    }
    
    private boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        
        for (int k = 0; k < 4; k++) {
            int nx = start[0] + dx[k];
            int ny = start[1] + dy[k];
            while (isValid(maze, nx, ny)) {
                nx += dx[k];
                ny += dy[k];
            }
            nx -= dx[k];
            ny -= dy[k];
            
            if (visited[nx][ny]) {
                continue;
            }
            
            visited[nx][ny] = true;
            if (dfs(maze, new int[]{nx, ny}, destination, visited)) {
                return true;
            } 
        }
        return false;
    }
    
    private boolean isValid(int[][] maze, int nx, int ny) {
        int rows = maze.length;
        int columns = maze[0].length;
        if (nx >= 0 && nx < rows && ny >= 0 && ny < columns && maze[nx][ny] == 0) {
            return true;
        }
        return false;
    }
}


