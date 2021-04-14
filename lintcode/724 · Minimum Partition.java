public class Solution {
    /**
     * @param nums: the given array
     * @return: the minimum difference between their sums 
     */
    public int findMin(int[] nums) {
        // write your code here
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int m = sum / 2;
        int n = nums.length;

        // state: dp[i][w] 代表前i个数 是否能凑出 和为w， true/ false
        boolean[][] dp = new boolean[n + 1][m + 1];
        // initialization;
        dp[0][0] = true;
        // for (int i = 1; i <= m; i++) {
        //     dp[0][i] = false;
        // }
        // function: dp[i][w] = dp[i - 1][w] or dp[i - 1][w - nums[i - 1]] (if w >= nums[i - 1])
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= m; w++) {
                if (w >= nums[i - 1]) {
                    dp[i][w] = dp[i - 1][w] || dp[i - 1][w - nums[i - 1]];
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // answer: 
        int x = 0;
        for (int v = m; v >= 0; v--) {
            if (dp[n][v]) {
                x = v;
                break;
            }
        }

        return sum - 2 * x;
    }
}