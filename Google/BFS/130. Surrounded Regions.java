Leetcode 130. Surrounded Regions
Lintcode 477 · Surrounded Regions
class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        if (board == null || m == 0 || board[0] == null || n == 0) {
            return;
        }
        
        // traverse the board, find all border 'o', then using bfs to search all connected 'o', and mark them 'T';
        // traverse the board again, mark all 'o' to 'x', mark all 'T' to 'o'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
                    bfs(board, i, j);
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void bfs(char[][] board, int x, int y) {
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        int m = board.length;
        int n = board[0].length;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        board[x][y] = 'T';
        
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = point.x + dx[k];
                int ny = point.y + dy[k];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 'O') {
                    queue.offer(new Point(nx, ny));
                    board[nx][ny] = 'T';
                }
            }
        }
    }
}

////////////////////////////////////////////////////////

public class Solution {
    /*
     * @param board: board a 2D board containing 'X' and 'O'
     * @return: nothing
     */
    private final int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public void surroundedRegions(char[][] board) {
        // write your code here
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        } 

        int rows = board.length, columns = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if ((i == 0 || i == rows - 1 || j == 0 || j == columns - 1) && board[i][j] == 'O') {
                    dfs(board, i, j, rows, columns);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y, int rows, int columns) {
        if (x < 0 || x >= rows || y < 0 || y >= columns || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'T';
        for (int[] dir : directions) {
            dfs(board, x + dir[0], y + dir[1], rows, columns);
        }
    }
}

// traverse the matrix, find all border 'o', using dfs to find all connected 'o's, and mark them as 'T'
// traverse the matrix again, mark all 'o' as 'x', mark all 'T' as 'o'
