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

///////////////////////////////////////////////////
public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // 滑动窗口型指针移动题型
        // time：O(n), 尽管两层循环， 但是j一直往前走，没有返回
        // space: O(1)
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int i = 0, j = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for (i = 0; i < nums.length; i++) {
            while (j < nums.length && sum < s) {
                sum += nums[j];
                j++;
            }
            if (sum >= s) {
                ans = Math.min(ans, j - i);
            }
            sum -= nums[i];
        }
        
        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }
        return ans;
    }
}