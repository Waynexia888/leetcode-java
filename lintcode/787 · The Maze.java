/////////////BFS/////////////////

class Point {
  int x, y;
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

public class Solution {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: whether the ball could stop at the destination
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // write your code here
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
            int nx = point.x;
            int ny = point.y;
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
            queue.offer(new Point(nx, ny));
          }
        }
        return false;
  }

  private boolean isValid(int[][] maze, int x, int y) {
    if (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
      return true;
    }
    return false;
  }

}


//////////////////////////////DFS///////////////////////////////