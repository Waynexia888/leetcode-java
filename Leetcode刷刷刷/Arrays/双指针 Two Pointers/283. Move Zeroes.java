// Given an array nums, write a function to move all 0's to the end of it 
// while maintaining the relative order of the non-zero elements.

// Example:

// Input: [0,1,0,3,12]
// Output: [1,3,12,0,0]
// Note:

// 1. You must do this in-place without making a copy of the array.
// 2. Minimize the total number of operations.

class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        
        while (j < nums.length) {
            nums[j] = 0;
            j++;
        }
    }
}

// 数组 - 同向双指针
// 时间复杂度: O(n)
// 空间复杂度: O(1)
// number of operation: nums.length;
// 当数组中0比较少的情况下使用该方法

// facebook - follow up?
// 当数组中0比较多的时候，该怎么做？

class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        // 当0比较多的时候，找到一个非0元素，与第一个元素交换位置，同时j++
        // number of operation: 2 * number of non-zero
        int j = 0; 
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}

