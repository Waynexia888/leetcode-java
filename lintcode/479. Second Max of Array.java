public class Second_Max_of_Array {
    /**
     * @param nums: An integer array
     * @return: The second max number in the array.
     */
    public int secondMax(int[] nums) {
        // 打擂台的方式
        // Math.max() 用来比较2个数的大小
        // 时间复杂度O(n), 空间复杂度O(1)

        int max = Math.max(nums[0], nums[1]);
        int second = Math.min(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (max < nums[i]) {
                second = max;
                max = nums[i];
            } else if (second < nums[i]) {
                second = nums[i];
            }
        }
        return second;

    }
}