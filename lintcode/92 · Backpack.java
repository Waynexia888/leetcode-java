public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }

        // state: dp[i][w] 代表前i个物品 是否能凑出 和为w的重量，true/false
        int n = A.length;
        boolean[][] dp = new boolean[n + 1][m + 1];

        // initialization: dp[0][0] = true; dp[0][1...w] = false
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            dp[0][i] = false;
        }

        // function: dp[i][w] = dp[i - 1][w] or dp[i - 1][w - A[i - 1]] (if w >= A[i - 1]) 
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= m; w++) {
                if (w >= A[i - 1]) {
                    dp[i][w] = dp[i - 1][w] || dp[i - 1][w - A[i - 1]];
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        // answer: 在 0 <= v <= m范围内， 找到一个dp[n][v]为true的最大v
        for (int v = m; v >= 0; v--) {
            if (dp[n][v]) {
                return v;
            }
        }
        return -1;
    }
}