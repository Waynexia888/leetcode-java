public class Solution {
    /**
     * @param n: a positive integer
     * @return: An integer
     */
    public int numSquares(int n) {
        // write your code here
        // state: dp[i]: 前i个数，被划分为完全平方数 的最少方案
        int [] dp = new int[n + 1];
        // initialization: dp[0]
        dp[0] = 0;
        // function: dp[i] = min(dp[i - j^2] + 1), which 1 <= j^2 <= i
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        // answer: dp[n] 
        return dp[n];
    }
}   