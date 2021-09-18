Leetcode 300. Longest Increasing Subsequence

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // state: dp[i]: the length of LIS ending in current index i
        int n = nums.length;
        int[] dp = new int[n];
        
        // initialization: dp[0..n - 1] = 1
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        
        // function: dp[i] = Math.max(dp[i], dp[j] + 1), where j < i && nums[j] < nums[i]
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        // answer: Math.max(dp[0 .. n - 1])
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}

///////////////////////////////////////////////////////////////

binary search： O(nlogn); space: O(n)

记录一个LIS数组
LIS[i] 表示长度为i的LIS的末尾的数最小是多少
最开始的时候，LIS[0] = 负无穷大， LIS[1..n] = 无穷大
for循环 nums数组， 从左到右依次处理每个数x
在LIS中找到第一个>= x的LIS[i] （下标)
将这个LIS[i]更新为x

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        int[] LIS = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            if (i == 0) {
                LIS[0] = Integer.MIN_VALUE;
                continue;
            }
            LIS[i] = Integer.MAX_VALUE;
        }
        
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            int index = firstGTE(LIS, nums[i]);
            LIS[index] = nums[i];
            maxLength = Math.max(maxLength, index);
        }
        return maxLength;
    }
    
    private int firstGTE(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (nums[start] >= target) {
            return start;
        }
        return end;
    }
}
