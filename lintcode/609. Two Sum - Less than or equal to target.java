public class Solution {
    /**
     * @param nums:   an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum5(int[] nums, int target) {
        // 排序 + 双指针问题, 找出所有的方案问题
        // 时间复杂度O(nlogn), 空间复杂度O(n)

        if (nums == null || nums.length < 2) {
            return 0;
        }

        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int count = 0;
        while (left < right) {
            if (nums[left] + nums[right] <= target) {
                count += right - left;
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}