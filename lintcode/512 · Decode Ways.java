public class Solution {
    /**
     * @param s: a string,  encoded message
     * @return: an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] arr = s.toCharArray();
        int n = arr.length;

        // state: dp[i]: 代表前i数字，解密成字符串的 最大方案个数
        int[] dp = new int[n + 1];

        // initialization: dp[0] = 1
        dp[0] = 1;

        // function: dp[i] = dp[i - 1] |s[i - 1] in range[1, 9] 
        //                 + dp[i - 2] |s[i - 2] in range[10, 26]
        for (int i = 1; i <= n; i++) {
            dp[i] = 0;
            if (arr[i - 1] >= '1' && arr[i - 1] <= '9') {
                dp[i] += dp[i - 1];
            }
            
            if (i > 1) {
                int number = (arr[i - 2] - '0') * 10 + (arr[i - 1] - '0');
                if (number >= 10 && number <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }

        // answer: dp[n]
        return dp[n];
    }
}