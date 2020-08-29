// Given an array of n positive integers and a positive integer s, find the minimal 
// length of a contiguous subarray of which the sum ≥ s. 
// If there isn't one, return 0 instead.

// Example: 

// Input: s = 7, nums = [2,3,1,2,4,3]
// Output: 2
// Explanation: the subarray [4,3] has the minimal length under the problem constraint.

// Follow up:
// If you have figured out the O(n) solution, try coding another solution of 
// which the time complexity is O(n log n). 

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int results = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;  // 使用left目的就是避免使用for loop
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (left <= i && sum >= s) {
                results = Math.min(results, i - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return results == Integer.MAX_VALUE ? 0 : results;
    }
}

// 本题思想有点像模拟sliding window
// 时间复杂度O(n);
// 空间复杂度O(1);