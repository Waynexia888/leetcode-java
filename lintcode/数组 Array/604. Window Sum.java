public class Solution {
    /**
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // 滑动窗口和: wsum = wsum(k个数) + nums[i] - nums[k - i]
        // time: O(n); space: O(1)
        int[] results = new int[nums.length - k + 1];
        if (nums == null || nums.length == 0 || k < 0) {
            return new int[]{};  // 或者：new int[0]
        }
        int wsum = 0;
        int index = 0;
        // 找size为k的第一个滑动窗口和
        for (int i = 0; i < k; i++) {
            wsum += nums[i];
        }
        results[index++] = wsum;
        
        for (int i = k; i < nums.length; i++) {
            wsum = wsum + nums[i] - nums[i - k];
            results[index++] = wsum;
        }
        return results;
    }
}