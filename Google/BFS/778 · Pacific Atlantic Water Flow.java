Lintcode 778 · Pacific Atlantic Water Flow
Leetcode 417. Pacific Atlantic Water Flow

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    /**
     * @param matrix: the given matrix
     * @return: The list of grid coordinates
     */
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return results;
        }

        int rows = matrix.length, columns = matrix[0].length;
        Queue<Point> pQueue = new LinkedList<>();
        Queue<Point> aQueue = new LinkedList<>();
        boolean[][] p = new boolean[rows][columns];   //store grid coordinates that can flow to pacific
        boolean[][] a = new boolean[rows][columns];

        for (int i = 0; i < rows; i++) {
            p[i][0] = true;
            pQueue.offer(new Point(i, 0));
            a[i][columns - 1] = true;
            aQueue.offer(new Point(i, columns - 1));
        }


        for (int i = 0; i < columns; i++) {
            p[0][i] = true;
            pQueue.offer(new Point(0, i));
            a[rows - 1][i] = true;
            aQueue.offer(new Point(rows - 1, i));
        }

        bfs(matrix, pQueue, p);
        bfs(matrix, aQueue, a);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (p[i][j] && a[i][j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    results.add(temp);
                }
            }
        }
        return results;
    }

    private void bfs(int[][] matrix, Queue<Point> queue, boolean[][] visited) {
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        int rows = matrix.length, columns = matrix[0].length;
        
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
                if (nx < 0 || nx >= rows || ny < 0 || ny >= columns) {
                    continue;
                }
                if (matrix[nx][ny] < matrix[p.x][p.y]) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                queue.offer(new Point(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }
}

//////////////////////////////////////////////////////////////////////////////
public class Solution {
    /**
     * @param matrix: the given matrix
     * @return: The list of grid coordinates
     */
    private final int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return results;
        }

        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] canReachP = new boolean[rows][columns];   //store grid coordinates that can flow to pacific
        boolean[][] canReachA = new boolean[rows][columns];

        for (int i = 0; i < rows; i++) {
            dfs(matrix, i, 0, canReachP);
            dfs(matrix, i, columns - 1, canReachA);
        }


        for (int i = 0; i < columns; i++) {
            dfs(matrix, 0, i, canReachP);
            dfs(matrix, rows - 1, i, canReachA);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (canReachP[i][j] && canReachA[i][j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    results.add(temp);
                }
            }
        }
        return results;
    }

    private void dfs(int[][] matrix, int x, int y, boolean[][] canReach) {
       if (canReach[x][y]) {
           return;
       }
       
       canReach[x][y] = true;
       for (int[] direction : directions) {
           int nextRow = x + direction[0];
           int nextCol = y + direction[1];
           if (nextRow < 0 || nextRow >= matrix.length || nextCol < 0 || nextCol >= matrix[0].length) {
               continue;
           }
           if (matrix[x][y] >  matrix[nextRow][nextCol]) {
               continue;
           }
           dfs(matrix, nextRow, nextCol, canReach);
       }
    }
}