public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        if (n < 2) {
            return n;
        }
        // state: dp[i]表示走到前i个台阶的方案个数
        int[] dp = new int[n + 1];

        // initialization: dp[0], dp[1]
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        // function: dp[i] = dp[i - 1] + dp[i - 2]
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // answer: dp[n]
        return dp[n];
    }
}