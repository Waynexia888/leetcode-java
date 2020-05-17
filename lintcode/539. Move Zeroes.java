public class Move_Zeroes {
    /**
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        // 两根指针, left, right,都指向数组第一个元素
        // right指针遍历循环nums数组，如果right指向当前的元素是非0，就冒泡排序，同时left指针++
        // 反之， right++
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right += 1;
        }

    }
}