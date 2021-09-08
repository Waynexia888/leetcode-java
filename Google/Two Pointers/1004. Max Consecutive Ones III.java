Leetcode 1004. Max Consecutive Ones III

class Solution {
    public int longestOnes(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int maxLength = 0, count = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                count++;
            }
            while (count > k) {
                //更新left指针的位置，使得区间0的个数满足<= k
                if (nums[left] == 0) {
                    left++;
                    count--;
                } else {
                    left++;
                }
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}

// 维护一个只有k个0的滑动窗口，right指针每次往右移动一位，顺便统计0的个数
// 当区间0的个数> k的时候， 不断移动left指针，直到区间0的个数满足<= k

