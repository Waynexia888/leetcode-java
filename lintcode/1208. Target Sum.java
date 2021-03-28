public class Solution {
    /**
     * @param nums: the given array
     * @param s: the given target
     * @return: the number of ways to assign symbols to make sum of integers equal to target S
     */
    public int count = 0;
    public int findTargetSumWays(int[] nums, int s) {
        // Write your code here
        if (nums == null) {
            return 0;
        }

        dfs(nums, s, 0, 0);
        return count;
    }

    private void dfs(int[] nums, int target, int startIndex, int sum) {
        if (startIndex == nums.length) {
            if (sum == target) {
                count++;
            }
            return;
        }

        // +
        sum += nums[startIndex];
        dfs(nums, target, startIndex + 1, sum);
        sum -= nums[startIndex];

        // -
        sum -= nums[startIndex];
        dfs(nums, target, startIndex + 1, sum);
        sum += nums[startIndex];
    }
}