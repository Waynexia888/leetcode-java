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

//////////////////////////////////////////////////////////
public class Solution {
    /**
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        // 套用同向双指针模版
        if (nums == null) {
            return;
        }
        
        int j = 0;  // j负责寻找下一个非0元素
        for (int i = 0; i < nums.length; i++) {
            j = Math.max(j, i + 1);
            while (j < nums.length && nums[j] == 0) {
                j++;
            }
            if (j >= nums.length) {
                break;
            }
            if (nums[i] == 0 && nums[j] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
    }
}