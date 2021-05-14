public class Solution {
    /**
     * @param n: An integer
     * @return: An Integer
     */
    public int climbStairs2(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (n == 2) {
            return n;
        }
        
        // state:dp[i]-> the possible ways the child can run up the stairs i
        int[] dp = new int[n + 1];

        // initialization: dp[0], dp[1], dp[2]
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
 

        // function: dp[i - 1] + dp[i - 2] + dp[i - 3]
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        // answer: dp[n]
        return dp[n];
    }
}
