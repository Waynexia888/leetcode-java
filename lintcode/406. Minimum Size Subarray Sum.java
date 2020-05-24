public class Minimum_Size_Subarray_Sum {
    /**
     * @param nums: an array of integers
     * @param s:    An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // 同向双指针问题：
        // 首先设置一个滑动窗口
        // 时间复杂度O(n), 空间复杂度O(1)
        if (nums == null || nums.length < 1) {
            return -1;
        }

        int left = 0, right = -1;
        int sum = 0;
        int minLength = nums.length + 1;

        while (left < nums.length) {
            if (right + 1 < nums.length && sum < s) {
                right++; // 要保证right不超出范围
                sum += nums[right];
            } else { // sum >= s
                sum -= nums[left];
                left++;
            }

            if (sum >= s) {
                minLength = Math.min(minLength, right - left + 1);
            }
        }

        if (minLength == nums.length + 1) {
            return -1;
        }
        return minLength;

    }
}