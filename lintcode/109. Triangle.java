public class Solution {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        // 分治法，这个答案会超时
        // 时间复杂度O(2^n)
        return divideConquer(triangle, 0, 0);
    }
    
    private int divideConquer(int[][] triangle, int x, int y) {
        if (x == triangle.length) {
            return 0;
        }
        
        int left = divideConquer(triangle, x + 1, y);
        int right = divideConquer(triangle, x + 1, y + 1);
        return Math.min(left, right) + triangle[x][y];
    }
}

///////////////////////////////////////////////////////////////
public class Solution {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        // DP - 求最值问题
        // 自顶向下的坐标型动态规划
        // 时间复杂度O(n^2), 空间复杂度O(n^2)
        if (triangle == null || triangle.length == 0) {
            return -1;
        }
        
        // state状态： dp[i][j] 表示从0, 0 到i, j 的最短路径值
        int row = triangle.length;
        int column = triangle[row - 1].length;
        int[][] dp = new int[row][column];
        
        // 初始化initialize: 三角形的左边和右边要初始化，因为他们分别没有左上角和右上角的点
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }
    
        //方程function: dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
        for (int i = 2; i < row; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }
        }
        
        // 答案answer: 最后一行的任意一个都可能是要返回的值， min(dp[row - 1])
        int best = dp[row - 1][0];
        for (int i = 1; i < column; i++) {
            best = Math.min(best, dp[row - 1][i]);
        }
        
        return best;
    }
}

///////////////////////////////////////////////////////////////