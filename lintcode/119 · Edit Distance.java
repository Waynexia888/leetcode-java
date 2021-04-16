public class Solution {
    /**
     * @param word1: A string
     * @param word2: A string
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();
        int m = s1.length;
        int n = s2.length;

        // state: dp[i][j] 表示s1前i个字符 和 s2前j个字符 的最小编辑距离
        int[][] dp = new int[m + 1][n + 1];

        // initialization: dp[0][j] = j (0 <= j <= n); dp[i][0] = i (0 <= i <= m)
        
        // function: dp[i][j] = min(dp[i][j - 1] + 1, 
        //                          dp[i - 1][j - 1] + 1,
        //                          dp[i - 1][j] + 1,
        //                          dp[i - 1][j - 1] if s1[i - 1] == s2[j - 1])
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                    continue;
                }

                if (j == 0) {
                    dp[i][j] = i;
                    continue;
                }
                dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]), dp[i - 1][j]) + 1;
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
            }
        }

        // answer: dp[m][n]
        return dp[m][n];
    }
}