public class Solution {
    /**
     * @param nums: An array of integers
     * @return: An integer
     */
    public int maxProduct(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // state: 
        // dp[j] = the maximum product of a subsequence with ending (a[j])
        // gp[j] = the minimum product of a subsequence with ending (a[j])

        int n = nums.length;
        int[] dp = new int[n];
        int[] gp = new int[n];
        
        // initialization: none; because we write dp[i] = nums[0] in for loop
        
        int result = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
            // edge case for (i - 1)
            if (i > 0) {
                // dp function 
                dp[i] = Math.max(dp[i], Math.max(nums[i] * dp[i - 1], nums[i] * gp[i - 1]));
            }
            
            gp[i] = nums[i];
            if (i > 0) {
                // gp function
                gp[i] = Math.min(gp[i], Math.min(nums[i] * dp[i - 1], nums[i] * gp[i - 1]));
            }
            
            result = Math.max(result, dp[i]);
        }
        // Answer
        return result;
    }
}

// time: O(n); space: o(n)