public class Solution {
    /**
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int value = Integer.MAX_VALUE;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum <= target) {
                value = Math.min(value, target - sum);
                left++;
            } else {
                value = Math.min(value, sum - target);
                right--;
            }
        }
        return value;
    }
}

// [-4, -1, 1, 2]
//  L          R 