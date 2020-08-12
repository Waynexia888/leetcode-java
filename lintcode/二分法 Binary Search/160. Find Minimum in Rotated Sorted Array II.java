public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // 最坏的情况是，每个数都看一遍，时间复杂度O(n)
        // space: O(1)
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        // int target = nums[nums.length - 1];   target一直保持最后一个数，会陷入死循环
        // 例如： [1, 1, -1, 1]
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else if (nums[mid] > nums[end]) {
                start = mid;
            } else {
                end = end - 1;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
}