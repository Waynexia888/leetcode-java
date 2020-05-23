public class Two_Sum_II_Input_array_is_sorted {
    /**
     * @param nums:   an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return new int[] { left + 1, right + 1 };
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }
}