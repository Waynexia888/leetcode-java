public class Solution {
    /**
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        
        // state: can it reach the position j?
        int n = A.length;
        boolean[] dp = new boolean[n];
        
        // initialization
        dp[0] = true;
        
        for (int j = 1; j < n; j++) {
            // dp[j] = false;
        
            // last jump from i to j
            for (int i = 0; i < j; i++) {
                if (dp[i] && i + A[i] >= j ) {
                    dp[j] = true;
                    break;
                }
            }
        }
        // Answer:
        return dp[n - 1];
    }
}

// time: O(n^2); space: O(n)