public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // write your code here
        int n = costs.length;
        if (costs == null || n == 0) {
            return 0;
        }
        
        // sequence type DP 
        // previous n + 1 houses, e.g. n + 1 = 4, previous 4 houses, means index: 0, 1, 2, 3
        int[][] dp = new int[n + 1][3];  
        dp[0][0] = dp[0][1] = dp[0][2] = 0;  // previous 0 houses, means no house need to be painted
        
        for (int i = 1; i <= n; i++) {
            // color of house (i - 1) -> j
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                // color of house (i - 2) -> k
                for (int k = 0; k < 3; k++) {
                    if (j != k) {  // not the same color
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + costs[i - 1][j]);
                    }
                }
            }
        }
        // answer
        return Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
    }
}

// for loop i, each row 
//     for loop j (j < 3), each column
//          for loop k (k < 3), make sure j != k
//              e.g. j = 0, k = (1 or 2); j = 1, k = (0 or 2); .....
// time: O(n * 3 * 3) = O(n)
// space: O(n * 3) = O(n)