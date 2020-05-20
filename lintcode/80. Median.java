public class Median {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the middle number of the array
     */
    public int median(int[] nums) {
        // 基于quick select思想, 时间复杂度O(n), 空间复杂度O(1)
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // kth number, not index,
        // example1: (5 + 1) /2 = 3; example2: (4 + 1)/ 2 = 2
        return quickSelect(nums, 0, nums.length - 1, (nums.length + 1) / 2);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }

        int left = start, right = end;
        int pivot = nums[(start + end) / 2];
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }

            while (left <= right && nums[right] > pivot) {
                right--;
            }

            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }

        // [start,....right, x, left, ......., end]
        if ((start + k - 1) <= right) {
            return quickSelect(nums, start, right, k);
        }
        if ((start + k - 1) >= left) {
            return quickSelect(nums, left, end, k - (left - start));
        }

        return nums[right + 1];

    }
}