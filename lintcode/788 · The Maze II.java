class Point {
  int x, y, l;
  public Point(int x, int y, int l) {
    this.x = x;
    this.y = y;
    this.l = l;
  }
}

public class Solution {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: the shortest distance for the ball to stop at the destination
     */
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // write your code here
        if (maze == null || maze.length == 0 || maze[0] == null || maze[0].length == 0) {
          return -1;
        }

        int rows = maze.length;
        int columns = maze[0].length;
        
        int[][] distance = new int[rows][columns];
        // distance[i][j] => total distance from start point to point (i, j)
        for (int i = 0; i < rows; i++) {
          for (int j = 0; j < columns; j++) {
            distance[i][j] = -1;
          }
        }
        
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(start[0], start[1], 0));

        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        while (!queue.isEmpty()) {
          Point point = queue.poll();
            
          for (int k = 0; k < 4; k++) {
            int nx = point.x;
            int ny = point.y;
            int nl = point.l;
            while (isValid(maze, nx, ny)) {
                nx += dx[k];
                ny += dy[k];
                nl++;
            }
            nx -= dx[k];
            ny -= dy[k];
            nl--;
           
            if (distance[nx][ny] == -1 || nl < distance[nx][ny]) {
                distance[nx][ny] = nl;
                queue.offer(new Point(nx, ny, nl));
            }
          }
        }

        if (distance[destination[0]][destination[1]] == -1) {
            return -1;
        }
        return distance[destination[0]][destination[1]];
    }

    private boolean isValid(int[][] maze, int x, int y) {
        if (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
            return true;
        }

        return false;
    }
}

///////////////////////DFS//////////////////////////////

public class Solution {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: the shortest distance for the ball to stop at the destination
     */
    public static int[] dx = new int[]{0, 0, 1, -1};
    public static int[] dy = new int[]{1, -1, 0, 0};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // write your code here
        if (maze == null || maze.length == 0 || maze[0] == null || maze[0].length == 0) {
          return -1;
        }

        int rows = maze.length;
        int columns = maze[0].length;
        
        int[][] distance = new int[rows][columns];
        // distance[i][j] => total distance from start point to point (i, j)
        for (int i = 0; i < rows; i++) {
          for (int j = 0; j < columns; j++) {
            distance[i][j] = -1;
          }
        }
        distance[start[0]][start[1]] = 0;
        dfs(maze, start, destination, distance);
        if (distance[destination[0]][destination[1]] == -1) {
            return -1;
        }
        return distance[destination[0]][destination[1]];
    }

    private void dfs(int[][] maze, int[] start, int[] destination, int[][] distance) {
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return;
        }

        for (int k = 0; k < 4; k++) {
            int nx = start[0];
            int ny = start[1];
            int steps = distance[nx][ny];
            while (isValid(maze, nx, ny)) {
                nx += dx[k];
                ny += dy[k];
                steps++;
            }
            nx -= dx[k];
            ny -= dy[k];
            steps--;

            if (distance[nx][ny] == -1 || steps < distance[nx][ny]) {
                distance[nx][ny] = steps;
                dfs(maze, new int[]{nx, ny}, destination, distance);
            } 
        }
    }

    private boolean isValid(int[][] maze, int x, int y) {
        if (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
            return true;
        }

        return false;
    }
}

