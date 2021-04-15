public class Solution {
    /**
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        char[] arrA = A.toCharArray();
        char[] arrB = B.toCharArray();
        int m = A.length();
        int n = B.length();

        // state: dp[i][j] 表示A的前i个字符 与 B的前j个字符 最长公共子序列长度
        int[][] dp = new int[m + 1][n + 1];

        // initialization: dp[i][0] = 0 | i = 0...m; dp[0][j] = 0 | j = 0...m


        // function: dp[i][j] = max(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1] + 1 if arrA[i - 1] == arrB[j - 1])
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (arrA[i - 1] == arrB[j - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                } 
            }
        }
        // answer: dp[m][n]
        return dp[m][n];
    }
}