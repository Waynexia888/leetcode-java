public class Solution {
    /**
     * @param s: the maximum length of s is 1000
     * @return: the longest palindromic subsequence's length
     */
    public int longestPalindromeSubseq(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        char[] ss = s.toCharArray();
        int n = ss.length;

        // state: dp[i][j] 表示i到j这一段区间的最长子序列长度
        int[][] dp = new int[n][n];

        // initialization:
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int i = 0; i < n - 1; i++) {
            if (ss[i] == ss[i + 1]) {
                dp[i][i + 1] = 2;
            } else {
                dp[i][i + 1] = 1;
            }
        }

        // function: dp[i][j] = max(dp[i + 1][j], dp[i][j - 1], dp[i + 1][j - 1] + 2 if ss[i] == ss[j])
        // 0, 1, 2, 3,....n - 3, .. n - 1
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                if (ss[i] == ss[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 2);
                }
            }
        }

        // answer: dp[0][n - 1];
        return dp[0][n - 1];
    }
}