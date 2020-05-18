public class Sort_Colors {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // 使用一次扫描的办法。
        // 设立三根指针，left, index, right。定义如下规则：
        // left 的左侧都是 0（不含 left）
        // right 的右侧都是 2（不含 right）
        // index 从左到右扫描每个数，如果碰到 0 就丢给 left，碰到 2 就丢给 right。碰到 1 就跳过不管。
        int left = 0, index = 0, right = nums.length - 1;
        while (index <= right) {
            if (nums[index] == 0) {
                int temp = nums[left];
                nums[left] = nums[index];
                nums[index] = temp;
                left += 1;
                index += 1;
            } else if (nums[index] == 2) {
                int temp = nums[right];
                nums[right] = nums[index];
                nums[index] = temp;
                right -= 1;
            } else {
                index += 1;
            }
        }
    }
}