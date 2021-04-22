public class Solution {
    /**
     * @param nums: an array of integer
     * @param k: an integer
     * @return: the largest sum
     */
    public int maxSubarray4(int[] nums, int k) {
        // 本题prefixSum的取值范围在[k, nums.length - 1]
        // minPrefixSum的取值范围在[0, nums.length - k]
        // 在minPrefixSum的取值范围内找到一个尽可能小的前缀和
        // 在prefixSum的取值范围内找到一个尽可能大的前缀和
        // time: O(n); space: O(1)
        
        if (nums == null || nums.length == 0 || nums.length < k) {
            return 0;
        }
        
        // sum([i, j]) 这段区间的最大值 = prefixSum[j + 1] - prefixSum[i]
        // 前j个数的前缀和 - 前i - 1个数的前缀和
        
        int prefixSum = 0;
        int minPrefixSum = 0;
        int leftSum = 0; // leftSum表示当前指向位置左侧k个位置的前缀和
        
        //第一个size为k的前缀和
        for (int i = 0; i < k; i++) {
           prefixSum += nums[i];
        }
        
        int maxSum = prefixSum;
        for (int i = k; i < nums.length; i++) {
            prefixSum += nums[i];
            leftSum += nums[i - k];
            minPrefixSum = Math.min(minPrefixSum, leftSum);
            maxSum = Math.max(maxSum, prefixSum - minPrefixSum);
        }
        return maxSum;
    }
}