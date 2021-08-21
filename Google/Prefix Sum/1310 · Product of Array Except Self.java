Leetcode 238. Product of Array Except Self
Lintcode 1310 · Product of Array Except Self

class Solution {
    public int[] productExceptSelf(int[] nums) {
        // time: O(n), space: O(1)
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int[] results = new int[nums.length];
        // from left to right, store the product of all left numbers expect itself
        results[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            results[i] = results[i - 1] * nums[i - 1];
        }
        
        // from right to left,
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            results[i] = results[i] * right;
            right = right * nums[i];
        }
        return results;
    }
}

// 本题借用prefix sum的思想，因为你需要知道除了当前数字的其他数字乘积（左半部分 * 右半部分）
// 所以可以先存起来
// 从左往右扫一遍，记录下当前数所有左半边的乘积
// 从右扫一遍，记录下当前数字所有右半边的乘积
// [1, 2, 3, 4]
// product pf all left numbers: [1, 1, 2, 6]
