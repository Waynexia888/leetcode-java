public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // i 到 j 的和可以用 前j个 数的和减去 前i-1 个数的和 来表示。
        // 故我们设置三个变量：
        // sum 表示前i个数的和;
        // maxSum 表示当前最大和;
        // minSum 表示当前最小和。
        // 每次操作指针向后移动一位，考虑要不要新加入这个数时，
        // 要比较 不加入这个数的maxSum 和 加入这个数后总共的和减去最小的和的sum-minSum 这两个数谁大。
        // 最小的和：最小和初始化为0，当指针后移，判断新的数字是否加入这个和时，
        // 要比较不加入这个数的 minSum 和加入这个数的 minSum 谁小，即这个数有没有使最小的和更小，若有则更新最小数。
        // 核心思想是剔除对最大和有副作用的。
        // 进一步详解可以参见：http://blog.csdn.net/u012255731/article/details/52302189
        // 时间复杂度：O(N)
        // 空间复杂度：O(1)
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int maxSum = Integer.MIN_VALUE;
        int minSum = 0;
        int prefixSum = 0;

        for (Integer number : nums) {
            prefixSum += number;
            maxSum = Math.max(maxSum, prefixSum - minSum);
            minSum = Math.min(minSum, prefixSum);
        }
        return maxSum;
    }
}
///////////////////////////////////////////////

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code here
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int max = Integer.MIN_VALUE;
        int min = 0;
        for (int i = 1; i < prefixSum.length; i++) {
            max = Math.max(max, prefixSum[i] - min);
            min = Math.min(min, prefixSum[i]);
        }
        return max;
    }
}

//   [−2,  2, −3, 4, −1,2, 1, −5, 3]
// [0, -2, 0, -3, 1, 0, 2, 3, -2, 1]

// max = 6
// min = -3
// time: O(n); space: O(n)