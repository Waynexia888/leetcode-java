public class Solution {
    /**
     * @param s: a string,  encoded message
     * @return: an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // write your code here
        char[] str = s.toCharArray();
        int n = str.length;
        if (str == null || n == 0) {
            return 0;
        }
        
        // since first n;
        // state: dp[i] = the total number of ways to decode the first i digits/ character.
        int[] dp = new int[n + 1];
        
        // initialize: there is one way to decode the empty string ""
        dp[0] = 1;
        
        // dp[i] = dp[i – 1] | (S[i – 1] is relate to a letter) + dp[i – 2] | (S[i – 2]S[i – 1] is relate to a letter).
        for (int i = 1; i <= n; i++) {
            dp[i] = 0;
            if (str[i - 1] >= '1' && str[i - 1] <= '9') {
                dp[i] += dp[i - 1];
            }
            
            if (i > 1) {
                // 'x' - '0' = x (x is an Integer, x should be the value from 0, 1, 2, ...., 9)
                // e.g. '7' - '0' = 7
                int j = 10 * (str[i - 2] - '0') + 1 * (str[i - 1] - '0');
                if (j >= 10 && j <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        // answer:
        return dp[n];
    }
}

// time: O(n); space: O(n)