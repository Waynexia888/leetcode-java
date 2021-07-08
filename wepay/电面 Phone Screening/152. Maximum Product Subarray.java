class Solution {
    public int maxProduct(int[] nums) {
        // time: O(n^2); space: O(1)
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int curProduct = 1;
            for (int j = i; j < nums.length; j++) {
                curProduct = curProduct * nums[j];
                maxProduct = Math.max(curProduct, maxProduct);
            }
        }
        return maxProduct;
    }
}

//////////////////////////////////////////////////////////////////

class Solution {
    public int maxProduct(int[] nums) {
        // time: O(n); space: O(n)
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // state: dp[i]: 以nums[i]结尾的子数组的最大乘积
        //        gp[i]: 以nums[i]结尾的子数组的最小乘积
        int n = nums.length;
        int[] dp = new int[n];
        int[] gp = new int[n];
        
        // initialization
        dp[0] = nums[0];
        gp[0] = nums[0];
        
        // function: 
        // dp[i] = Math.max(nums[i], Math.max(nums[i] * dp[i - 1], nums[i] * gp[i - 1]));
        // gp[i] = Math.min(nums[i], Math.min(nums[i] * dp[i - 1], nums[i] * gp[i - 1]));
        int maxProduct = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], Math.max(nums[i] * dp[i - 1], nums[i] * gp[i - 1]));
            gp[i] = Math.min(nums[i], Math.min(nums[i] * dp[i - 1], nums[i] * gp[i - 1]));
            maxProduct = Math.max(maxProduct, dp[i]);
        }
        
        // answer:
        return maxProduct;
    }
}

//////////////////////////////////////////////////////////////////////////////

class Solution {
    public int maxProduct(int[] nums) {
        // time: O(n); space: O(1)
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int max = nums[0]; // max用来保存以当前位置结尾的子数组最大乘积
        int min = nums[0]; // min用来保存以当前位置结尾的子数组最小乘积
        int maxProduct = nums[0];  // given input: [-2]
        
        // dp[i] = Math.max(nums[i], Math.max(nums[i] * dp[i - 1], nums[i] * gp[i - 1]));
        // gp[i] = Math.min(nums[i], Math.min(nums[i] * dp[i - 1], nums[i] * gp[i - 1]));
      
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(nums[i], Math.max(nums[i] * max, nums[i] * min));
            min = Math.min(nums[i], Math.min(nums[i] * temp, nums[i] * min));
            maxProduct = Math.max(maxProduct, max);
        }
        
        // answer:
        return maxProduct;
    }
}