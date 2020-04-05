// Lintcode 479: 数组第二大数 · Second Max of Array

// 题目描述: Find the second max number in a given array.
// 在数组中找到第二大的数。

// Example1:
// Input: [1,3,2,4]
// Output: 3

// Example2:
// Input: [1,1,2,2]
// Output: 2

public class Solution {
    /**
     * @param nums: An integer array
     * @return: The second max number in the array.
     */
    public int secondMax(int[] nums) {
        // write your code here

        // int max = 0;    不能这样写, 例如：[1, -1, -2]
        // int secondMax = 0;

        int max = Math.max(nums[0], nums[1]);
        int secondMax = Math.min(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (max < nums[i]) {
                secondMax = max;
                max = nums[i];
            } else if (secondMax < nums[i]) {
                secondMax = nums[i];
            }
        }
        return secondMax;
    }
}

