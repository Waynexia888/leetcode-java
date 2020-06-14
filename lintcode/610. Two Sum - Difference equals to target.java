public class Solution {
    /**
     * @param nums:   an array of Integer
     * @param target: an integer
     * @return: [num1, num2] (num1 < num2)
     */
    public int[] twoSum7(int[] nums, int target) {
        // 由于数组是有序的， 且题目要求不使用额外空间，可以考虑使用二分法
        // 注意： target需要取绝对值
        // 时间复杂度O(nlogn), 空间复杂度O(1)

        if (nums == null || nums.length < 2) {
            return new int[] { -1, -1 };
        }

        target = Math.abs(target);
        for (int i = 0; i < nums.length; i++) {
            int j = binarySearch(nums, i + 1, nums.length - 1, target + nums[i]);
            if (j != -1) {
                return new int[] { nums[i], nums[j] };
            }
        }
        return new int[] { -1, -1 };
    }

    public int binarySearch(int[] nums, int start, int end, int target) {

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
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