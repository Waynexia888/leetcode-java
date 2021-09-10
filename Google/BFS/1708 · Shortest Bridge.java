Lintcode 1708 · Shortest Bridge

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    private final int[] dx = new int[]{0, 0, 1, -1};
    private final int[] dy = new int[]{1, -1, 0, 0};

    public int ShortestBridge(int[][] A) {
        Queue<Point> queue = new LinkedList<>();
        int rows = A.length, columns = A[0].length;
        boolean findOneBridge = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (A[i][j] == 1) {
                    dfs(A, i, j, queue, rows, columns);
                    findOneBridge = true;
                    break;
                }
            }
            if (findOneBridge) {
                break;
            }
        }

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point p = queue.poll();
                for (int k = 0; k < 4; k++) {{
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];
                    if (isValid(A, nx, ny, rows, columns)) { // within the matrix, != 2
                        if (A[nx][ny] == 1) {
                            return steps;
                        } else { // == 0
                            queue.offer(new Point(nx, ny));
                            A[nx][ny] = 2;
                        }
                    }
                }}
            }
            steps++;
        }
        return steps;
    }

    private void dfs(int[][] A, int x, int y, Queue<Point> queue, int rows, int columns) {
        if (x < 0 || x >= rows || y < 0 || y >= columns || A[x][y] != 1)  {
            return;
        }

        A[x][y] = 2;
        queue.offer(new Point(x, y));
        dfs(A, x, y + 1, queue, rows, columns);
        dfs(A, x, y - 1, queue, rows, columns);
        dfs(A, x + 1, y, queue, rows, columns);
        dfs(A, x - 1, y, queue, rows, columns);
    }

    private boolean isValid(int[][] A, int x, int y, int rows, int columns) {
        if (x < 0 || x >= rows || y < 0 || y >= columns) {
            return false;
        }
        if (A[x][y] == 2) {
            return false;
        }
        return true;
    }
}