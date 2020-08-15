public class Solution {
    /**
     * @param grid: a 2D integer grid
     * @return: an integer
     */
    public int zombie(int[][] grid) {
        // BFS, 
        // 这题与611 题不一样的是， 初始化queue的时候，放进去的是一群僵尸， 而不是一个
        // 本题需要days--； 而611题，不需要days--； 因为611题在满足条件后，有了一个判断， 如果满足判断， 就返回值
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        
        int rows = grid.length;
        int columns = grid[0].length;
        
        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();
        boolean[][] isUsed = new boolean[rows][columns];
        
        // 把一群僵尸放入队列中
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    queueX.offer(i);
                    queueY.offer(j);
                    isUsed[i][j] = true;
                }
            }
        }
        
        int days = 0;
        while (!queueX.isEmpty()) {
            days++;
            int size = queueX.size();
            for (int i = 0; i < size; i++) {
                int curX = queueX.poll();
                int curY = queueY.poll();
                
                for (int k = 0; k < 4; k++) {
                    int nx = curX + dx[k];
                    int ny = curY+ dy[k];
                    
                    if (nx >= 0 && nx < rows && ny >= 0 && ny < columns && grid[nx][ny] == 0 && isUsed[nx][ny] == false) {
                        queueX.offer(nx);
                        queueY.offer(ny);
                        isUsed[nx][ny] = true;
                    }
                }
            }
        }
        days--;     // 这一步不要忘了
        
        // 如果不能感染所有的人， 返回-1
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 0 && isUsed[i][j] == false) {
                    return -1;
                }
            }
        }
        return days;
    }
}

//////////////////////////////////////////////////////////
// 新的解法
public class Solution {
    /**
     * @param grid: a 2D integer grid
     * @return: an integer
     */

    public int PEOPLE = 0;
    public int ZOMBIE = 1;
    public int WALL = 2;

    
    class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int zombie(int[][] grid) {
        // write your code here
        // 从所有的僵尸装进队列进行bfs
        //      每经过一天
        //      bfs将所有这一天(分层）被感染的人类加入队列
        // 遍历矩阵，查看所有的位置，是否存在人类未被感染
        
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
         return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == ZOMBIE) {
                    queue.offer(new Point(i, j));
                    visited[i][j] = true;
                }
            }
        }
        
        int days = 0;
        while (!queue.isEmpty()) {
            days++;
            // 不能在循环里写i < queue.size, 因为后面会不断在queue里加东西
            int size = queue.size(); 
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = point.x + DIRECTIONS[k][0];
                    int ny = point.y + DIRECTIONS[k][1];
                    if (isValid(grid, visited, nx, ny)) {
                        // grid[nx][ny] = ZOMBIE; //把人变成僵尸，这一步可写可不写
                        queue.offer(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == PEOPLE && !visited[i][j]) {
                    return -1;
                }
            }
        }
        
        return days - 1;
    }
    
    private boolean isValid(int[][] grid, boolean[][] visited, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;
        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == PEOPLE && !visited[x][y]) {
            return true;
        }
        return false;
    }
}