Leetcode 1509. Minimum Difference Between Largest and Smallest Value in Three Moves

class Solution {
    public int minDifference(int[] nums) {
        if (nums.length < 4) {
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int n = nums.length;
        // find first 4 smaller and first 4 larger;
        for (int i = 0; i < 4; i++) {
            min = Math.min(min, nums[n - 4 + i] - nums[i]);
        }
        return min;
        
    }
}

// [0, 1, 1, 4, 6, 6, 6]
// 0, 1, 1, 4
// 4, 6, 6, 6

// time: O(nlogn); space: O(1)