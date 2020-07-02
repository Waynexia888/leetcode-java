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