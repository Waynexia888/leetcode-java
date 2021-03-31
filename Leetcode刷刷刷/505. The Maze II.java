class Point {
    int x, y, l;
    public Point(int x, int y, int l) {
        this.x = x;
        this.y = y;
        this.l = l;
    }
}
class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0] == null || maze[0].length == 0) {
            return 0;
        }
        
        // distance[i][j] => distance from start to point (i, j)
        int rows = maze.length;
        int columns = maze[0].length;
        int[][] distance = new int[rows][columns];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                distance[i][j] = Integer.MAX_VALUE;
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
                while (nx >= 0 && nx < rows && ny >= 0 && ny < columns && maze[nx][ny] == 0) {
                    nx += dx[k];
                    ny += dy[k];
                    nl ++;
                }
                nx -= dx[k];
                ny -= dy[k];
                nl--;
                
                if (distance[nx][ny] == Integer.MAX_VALUE || nl < distance[nx][ny]) {
                    distance[nx][ny] = nl;
                    queue.offer(new Point(nx, ny, nl));
                }
            }
        }
        
        if (distance[destination[0]][destination[1]] == Integer.MAX_VALUE) {
            return -1;
        }
        return distance[destination[0]][destination[1]]; 
    }
}

//////////////////////////////////////////////////

class Point {
    int x, y, l;
    public Point(int x, int y, int l) {
        this.x = x;
        this.y = y;
        this.l = l;
    }
}
class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0] == null || maze[0].length == 0) {
            return 0;
        }
        
        // distance[i][j] => distance from start to point (i, j)
        int rows = maze.length;
        int columns = maze[0].length;
        int[][] distance = new int[rows][columns];
        
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
                while (nx >= 0 && nx < rows && ny >= 0 && ny < columns && maze[nx][ny] == 0) {
                    nx += dx[k];
                    ny += dy[k];
                    nl ++;
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
}

