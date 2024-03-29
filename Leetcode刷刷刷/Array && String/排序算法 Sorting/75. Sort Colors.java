// Given an array with n objects colored red, white or blue, sort them in-place 
// so that objects of the same color are adjacent, with the colors in the order red, 
// white and blue.

// Here, we will use the integers 0, 1, and 2 to represent the color red, white, 
// and blue respectively.

// Note: You are not suppose to use the library's sort function for this problem.

// Example:

// Input: [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]
// Follow up:

// A rather straight forward solution is a two-pass algorithm using counting sort.
// First, iterate the array counting number of 0's, 1's, and 2's, 
// then overwrite array with total number of 0's, then 1's and followed by 2's.
// Could you come up with a one-pass algorithm using only constant space?

class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int left = 0, right = nums.length - 1;
        int index = 0;
        
        while (index <= right) {
            if (nums[index] == 0) {
                swap(nums, index, left);
                index++;
                left++;
            } else if (nums[index] == 1) {
                index++;
            } else {
                swap(nums, index, right);
                right--; // 因为换回来的数有可能是0， 因此index不++;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// 本题思想： 相向双指针 - 三路快排
// 使用一次扫描的办法。
// 设立三根指针，left, index, right。定义如下规则：
// left 的左侧都是 0（不含 left）
// right 的右侧都是 2（不含 right）
// index 从左到右扫描每个数，如果碰到 0 就丢给 left，碰到 2 就丢给 right。碰到 1 就跳过不管。
// 时间复杂度O(n), 空间复杂度O(1)