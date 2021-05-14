public class Solution {
    /*
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(List<Integer> nums) {
        // write your code here
        if (nums == null || nums.size() == 0) {
            return 0;
        }

        int sum = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (Integer num : nums) {
            sum += num;
            min = Math.min(min, sum - max);
            max = Math.max(max, sum);
        }
        return min;
    }
}

// [1, -1, -2, 1]
// sum = 1 + -1 = 0 + -2 = -2 + 1 = -1
// min = -3
// max = 1