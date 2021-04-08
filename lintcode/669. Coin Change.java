public class Solution {
    /**
     * @param coins:  a list of integer
     * @param amount: a total amount of money amount
     * @return: the fewest number of coins that you need to make up
     */
    public int coinChange(int[] coins, int amount) {
        int n = coins.length; // number of coins
        // f[0], f[1], ..., f[amount]
        int[] dp = new int[amount + 1];

        // initialization
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            // last coin A[k]
            for (int k = 0; k < n; k++) {
                // boundary
                if (i >= coins[k] && dp[i - coins[k]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[k]] + 1);
                }
            }
        }

        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        } 
        return dp[amount];
    }
}