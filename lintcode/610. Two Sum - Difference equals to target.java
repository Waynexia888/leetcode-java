public class Solution {
    /**
     * @param nums: an array of Integer
     * @param target: an integer
     * @return: [num1, num2] (num1 < num2)
     */
    public int[] twoSum7(int[] nums, int target) {
        // 题目要求不使用额外空间，即不能使用哈希表
        // 那么在一个排好序的数组中，快速查找target有没有，我们想到了二分法
        // time: O(nlogn); space: O(1)
        int[] results = new int[2];

        target = Math.abs(target);
        for (int i = 0; i < nums.length; i++) {
            int j = binarySearch(nums, i + 1, nums.length - 1, target + nums[i]);
            if (j != -1) {
                results[0] = nums[i];
                results[1] = nums[j];
                return results;
            }
        }
        return new int[]{-1, -1};
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {{
                end = mid;
            }}
        }
        if (nums[start] == target) {
            return start;
        }

        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}

////////////////////////////////////////////////////////////////

public class Solution {
    /**
     * @param nums:   an array of Integer
     * @param target: an integer
     * @return: [num1, num2] (num1 < num2)
     */
    public int[] twoSum7(int[] nums, int target) {
        // 使用同向双指针的模版解题
        // 时间复杂度O(n), 空间复杂度O(1)

        if (nums == null || nums.length < 2) {
            return new int[] { -1, -1 };
        }

        target = Math.abs(target); // 需要取绝对值，例如: [0, 5, 7], target = -2, 不取绝对值返回的是[-1, -1]
        int j = 1;
        for (int i = 0; i < nums.length; i++) {
            j = Math.max(j, i + 1); // 始终保证j在i的右边, 例如: [0, 1, 2, 2], target = 0, 如果没有这个条件，会返回[1, 1]
            while (j < nums.length && nums[j] - nums[i] < target) {
                j++;
            }
            if (j >= nums.length) {
                break;
            }
            if (nums[j] - nums[i] == target) {
                return new int[] { nums[i], nums[j] };
            }
        }
        return new int[] { -1, -1 };
    }
}