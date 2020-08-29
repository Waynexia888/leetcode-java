// Given an array nums of n integers where n > 1,  return an array output such that 
// output[i] is equal to the product of all the elements of nums except nums[i].

// Example:

// Input:  [1,2,3,4]
// Output: [24,12,8,6]
// Constraint: It's guaranteed that the product of the elements of any prefix or 
// suffix of the array (including the whole array) fits in a 32 bit integer.

// Note: Please solve it without division and in O(n).

// Follow up:
// Could you solve it with constant space complexity? (The output array does not 
// count as extra space for the purpose of space complexity analysis.)


class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        
        int[] results = new int[nums.length];
        
        // 计算 前i项的乘积（不包括自己）
        results[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            results[i] = results[i - 1] * nums[i - 1];
        }
        // 计算 后i项的乘积（不包括自己） 
        // results = 前i项的乘积（不包括自己）* 后i项的乘积（不包括自己） 
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            results[i] = results[i] * right;
            right = right * nums[i];
        }
        return results;
    }
}

// 同向双指针 - 子数组问题
// 分段式处理（2个以上的for loop）
// 时间复杂度:O(n);
// 空间复杂度:O(n)