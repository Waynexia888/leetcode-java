/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path 
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // 简单图，找最短路径
        // 与433: number of island的区别是， 这题使用了BFS的层级遍历，每次寻找一层， 然后depth + 1；
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        
        int[] dx = new int[]{1, 1, -1, -1, 2, 2, -2, -2};
        int[] dy = new int[]{2, -2, 2, -2, 1, -1, 1, -1};
        int rows = grid.length;
        int columns = grid[0].length;
        
        // 如何去重？ 如果使用Set<Point> 会超时，TLE, 因此考虑使用二维数组；
        Queue<Point> queue = new LinkedList<>();
        boolean[][] isUsed = new boolean[grid.length][grid[0].length];
        queue.offer(source);
        isUsed[source.x][source.y] = true;
        if (source.x == destination.x && source.y == destination.y) {
            return 0;
        }
        
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point cur = queue.poll();
                
                for (int k = 0; k < 8; k++) {
                    int nx = cur.x + dx[k];
                    int ny = cur.y + dy[k];
                    // 在棋盘范围内， 并且不是障碍物， 且没被访问过
                    if (nx >= 0 && nx < rows && ny >= 0 && ny < columns && !grid[nx][ny] && isUsed[nx][ny] == false) {
                        if (nx == destination.x && ny == destination.y) {
                            return depth;
                        }
                        queue.offer(new Point(nx, ny));
                        isUsed[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }
}

///////////////////////////////////////////////////////////////////
// 双向宽度优先搜索
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path 
     */
    int[][] DIRECTIONS = {
        {1, 2},
        {1, -2},
        {-1, 2},
        {-1, -2},
        {2, 1},
        {2, -1},
        {-2, 1},
        {-2, -1}
    };
    
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // 双向宽度优先搜索
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        // 如果起点和终点的位置一样， 则骑士不需要移动，返回0
        if (source.x == destination.x && source.y == destination.y) {
            return 0;
        }
        // 如果终点位置是1， 则不存在这样的路径， 返回-1
        if (grid[destination.x][destination.y]) {
            return -1;
        }
        
        Queue<Point> forwardQueue = new LinkedList<>();
        Queue<Point> backwardQueue = new LinkedList<>();
        int row = grid.length;
        int column = grid[0].length;
        boolean[][] forwardSet = new boolean[row][column];
        boolean[][] backwardSet = new boolean[row][column];
        forwardQueue.offer(new Point(source.x, source.y));
        backwardQueue.offer(new Point(destination.x, destination.y));
        forwardSet[source.x][source.y] = true;
        backwardSet[destination.x][destination.y] = true;
        
        int distance = 0;
        while (!forwardQueue.isEmpty() && !backwardQueue.isEmpty()) {
            distance++;
            // 由当前queue扩展下一层queue，并在forwardSet里标记，如果有在backwardSet出现，则return distance
            if (extendQueue(grid, forwardQueue, forwardSet, backwardSet)) {
                return distance;
            }
            
            distance++;
            if (extendQueue(grid, backwardQueue, backwardSet, forwardSet)) {
                return distance;
            }
        }
        return -1;
    }
    
    private boolean extendQueue(boolean[][] grid, Queue<Point> queue, boolean[][] visited, boolean[][] oppositeVisited) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            Point cur = queue.poll();
            
            for (int k = 0; k < 8; k++) {
                int nx = cur.x + DIRECTIONS[k][0];
                int ny = cur.y + DIRECTIONS[k][1];
                if (!isValid(grid, nx, ny, visited)) {
                    continue;
                }
                if (oppositeVisited[nx][ny]) {
                    return true;
                }
                queue.offer(new Point(nx, ny));
                visited[nx][ny] = true;
            }
        }
        return false;
    }
    
    private boolean isValid(boolean[][] grid, int x, int y, boolean[][] visited) {
        // x, y 在棋盘内， 且所在位置的值不是1， 且没被访问过
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && !grid[x][y] && !visited[x][y]) {
            return true;
        }
        return false;
    }
}


////////////////////////////////////////////////////////////////////////////////
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path 
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // 把起点加入到队列里，然后进行bfs分层遍历
        //     构建该点能位移的八种可能性，判断收否在棋盘内，收否是障碍物，是否被访问过
        //     如果不是，则加入到队列里，并标记访问过



        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int[] dx = new int[]{1, 1, -1, -1, 2, 2, -2, -2};
        int[] dy = new int[]{2, -2, 2, -2, 1, -1, 1, -1};

        int rows = grid.length;
        int columns = grid[0].length;

        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][columns];
        queue.add(source);
        visited[source.x][source.y] = true;

        int path = 0;
        while (!queue.isEmpty()) {
            // path++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                if (point.x == destination.x && point.y == destination.y) {
                    return path;
                }

                for (int k = 0; k < 8; k++) {
                    int nx = point.x + dx[k];
                    int ny = point.y + dy[k];
                  
                    if (isValid(grid, nx, ny, visited)) {
                        queue.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
            if (queue.size() != 0) {
                path++;
            } else {
                break;
            }
           
        }
        return -1;
    }
    
    private boolean isValid(boolean[][] grid, int nx, int ny, boolean[][] visited) {
        int rows = grid.length;
        int columns = grid[0].length;
        if (nx < 0 || nx >= rows || ny < 0 || ny >= columns) {
            return false;
        }
        if (grid[nx][ny]) {
            return false;
        }
        if (visited[nx][ny] == true) {
            return false;
        }
        return true;
    }
}
