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