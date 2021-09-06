Lintcode 406 · Minimum Size Subarray Sum

public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // time: O(nlogn); space: O(n)
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int[] prefixSum = getPrefixSumArray(nums);
        int minSize = Integer.MAX_VALUE;

        // 枚举nums数组中的每一个位置（当作起点i), 用二分法找出终点下标j，使得这个区间的sum >= s
        for (int i = 0; i < nums.length; i++) {
            int j = getEndOfSubarray(prefixSum, i, s); // 可能return -1
            if (j == -1) {
                continue;
            }
            minSize = Math.min(minSize, j - i + 1);
        }
        return minSize == Integer.MAX_VALUE ? -1 : minSize;
    }

    private int[] getPrefixSumArray(int[] nums) {
        int[] prefixSumArray = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSumArray[i + 1] = prefixSumArray[i] + nums[i];
        }
        return prefixSumArray;
    }

    private int getEndOfSubarray(int[] prefixSum, int i, int s) {
        int start = i;
        int end = prefixSum.length - 2; // 下标nums.length - 1 = prefixSumArray.length - 2;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if ((prefixSum[mid + 1] - prefixSum[i]) >= s) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if ((prefixSum[start + 1] - prefixSum[i]) >= s) {
            return start;
        }

        if ((prefixSum[end + 1] - prefixSum[i]) >= s) {
            return end;
        }
        return -1;
    }
}

///////////////////////////////////////////////////////

public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int minSize = Integer.MAX_VALUE;
        int sumOfSubarray = 0;
        int end = 0;
        for (int start = 0; start < nums.length; start++) {
            while (end < nums.length && sumOfSubarray < s) {
                sumOfSubarray += nums[end];
                end++;
            }

            if (sumOfSubarray >= s) {
                minSize = Math.min(minSize, end - start);
            }
            sumOfSubarray -= nums[start];
        }
        return minSize == Integer.MAX_VALUE ? -1 : minSize;
    }
}