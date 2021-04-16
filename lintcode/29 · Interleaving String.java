public class Solution {
    /**
     * @param s1: A string
     * @param s2: A string
     * @param s3: A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        char[] arr3 = s3.toCharArray();

        int m = arr1.length;
        int n = arr2.length;
        if (m + n != arr3.length) {
            return false;
        }

        // state: dp[i][j] 表示前i + j个字符 是否由 A前i个字符 和 B前j个字符 交错形成. true/ false
        boolean[][] dp = new boolean[m + 1][n + 1];

        // initialization: 空串 由A的空串 和 B的空串 交错形成
        // dp[0][0] = true;

        // function: dp[i][j] = dp[i - 1][j] (arr3[i + j - 1] == arr1[i - 1])
        //                   or dp[i][j - 1] (arr3[i + j - 1] == arr2[j - 1])
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                    continue;
                }

                dp[i][j] = false;
                if (i > 0 && arr3[i + j - 1] == arr1[i - 1]) {
                    dp[i][j] |= dp[i - 1][j];
                }

                if (j > 0 && arr3[i + j - 1] == arr2[j - 1]) {
                    dp[i][j] |= dp[i][j - 1];
                }
            }
        }
        // answer: dp[m][n]
        return dp[m][n];
    }
}