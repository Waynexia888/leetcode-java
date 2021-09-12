Lintcode 1811 · Find Maximum Gold

public class Solution {
    /**
     * @param grids: a integer two-dimensional array
     * @return: return the maximum sum of golds 
     */
    private int maxGolds = 0;
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int FindMaximumGold(int[][] grids) {
        // write your code here
        if (grids == null || grids.length == 0 || grids[0] == null || grids[0].length == 0) {
            return 0;
        }

        int rows = grids.length, columns = grids[0].length;
        boolean[][] visited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grids[i][j] != 0) {
                    visited[i][j] = true;
                    dfs(grids, i, j, visited, grids[i][j]);
                    visited[i][j] = false;
                }
            }
        }
        return maxGolds;
    }

    private void dfs(int[][] grids, int x, int y, boolean[][] visited, int sum) {
        maxGolds = Math.max(maxGolds, sum);

        for (int[] dir : directions) {
            int nx = x + dir[0], ny = y + dir[1];
            if (nx < 0 || nx >= grids.length || ny < 0 || ny >= grids[0].length) {
                continue;
            }
            if (visited[nx][ny]) {
                continue;
            }
            if (grids[nx][ny] == 0) {
                continue;
            }
            sum += grids[nx][ny];
            visited[nx][ny] = true;
            dfs(grids, nx, ny, visited, sum);
            visited[nx][ny] = false;
            sum -= grids[nx][ny];
        }
    }
}

时间复杂度：O（（n*m）^2）
n为行数，m为列数，最坏的情况是图全部都是金子，那么从任何点出发都需要遍历全图。

空间复杂度：O(n*m)
n为行数，m为列数，递归工作栈可能会存全图。


/////////////////////////////////////////////////////////////////////

没有使用全局变量，将结果保存在数组中，将数组当作参数传入递归

public class Solution {
    /**
     * @param grids: a integer two-dimensional array
     * @return: return the maximum sum of golds 
     */
    // private int maxGolds = 0;
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int FindMaximumGold(int[][] grids) {
        // write your code here
        if (grids == null || grids.length == 0 || grids[0] == null || grids[0].length == 0) {
            return 0;
        }

        int[] maxGolds = new int[1];

        int rows = grids.length, columns = grids[0].length;
        boolean[][] visited = new boolean[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grids[i][j] != 0) {
                    visited[i][j] = true;
                    dfs(grids, i, j, visited, grids[i][j], maxGolds);
                    visited[i][j] = false;
                }
            }
        }
        return maxGolds[0];
    }

    private void dfs(int[][] grids, int x, int y, boolean[][] visited, int sum, int[] maxGolds) {
        maxGolds[0] = Math.max(maxGolds[0], sum);

        for (int[] dir : directions) {
            int nx = x + dir[0], ny = y + dir[1];
            if (nx < 0 || nx >= grids.length || ny < 0 || ny >= grids[0].length) {
                continue;
            }
            if (visited[nx][ny]) {
                continue;
            }
            if (grids[nx][ny] == 0) {
                continue;
            }
            sum += grids[nx][ny];
            visited[nx][ny] = true;
            dfs(grids, nx, ny, visited, sum, maxGolds);
            visited[nx][ny] = false;
            sum -= grids[nx][ny];
        }
    }
}

//////////////////////////////////////////////////////////////////

DFS算法是一一个递归算法，需要借助一个递归工作栈，故它的空问复杂度为O(V）。

遍历图的过程实质上是对每个顶点查找其邻接点的过程，其耗费的时间取决于所采用结构。

邻接表表示时，查找所有顶点的邻接点所需时间为O(E)，访问顶点的邻接点所花时间为O（V）,此时，总的时间复杂度为O(V+E)。

邻接矩阵表示时，查找每个顶点的邻接点所需时间为O(V)，要查找整个矩阵，故总的时间度为O(V^2)。 

 v为图的顶点数，E为边数。


