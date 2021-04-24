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
        // 时间复杂度O(n), 空间复杂度O(1)
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

///////////////////////////////////////////////////////////////
public class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        //  counting sort 计数排序算法
        // 时间复杂度O(n), 空间复杂度O(range)
        
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        
        for (int number : nums) {
            if (number == 0) {
                count0++;
            } 
            if (number == 1) {
                count1++;
            }
            if (number == 2) {
                count2++;
            }
        }
        
        for (int i = 0; i < count0; i++) {
            nums[i] = 0;
        }
        
        for (int i = count0; i < (count0 + count1); i++) {
            nums[i] = 1;
        }
        
        for (int i = (count0 + count1); i < nums.length; i++) {
            nums[i] = 2;
        }
    }
}

////////////////////////////////////////////////////////////////

public class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }

        int left = 0, right = nums.length - 1;
        int index = 0;
        while (index <= right) {
            if (nums[index] == 0) {
                swap(nums, index, left);
                left++;
                index++;
            } else if (nums[index] == 1) {
                index++;
            } else {
                swap(nums, index, right);
                right--;
            }

        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}