// Given an unsorted array return whether an increasing subsequence of length 3 
// exists or not in the array.

// Formally the function should:

// Return true if there exists i, j, k
// such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
// Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.

// Example 1:

// Input: [1,2,3,4,5]
// Output: true
// Example 2:

// Input: [5,4,3,2,1]
// Output: false

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
            } else if (nums[i] <= secondMin) {
                secondMin = nums[i];
            } else if (nums[i] > secondMin) {
                return true;
            }
        }
        return false;
    }
}

// 本题思想 - 打擂台
// for循环整个数组， 找到一个最小的数， 然后找一个第二小的数，然后在剩下的数里，找一个比第二小的数大的数即可
// 时间复杂度: O(n)
// 空间复杂度: O(1)

// 几个定义：
// subsequence（子序列）：子序列的要求是连续的数或者不连续的数
// subarray（子数组）： 子数组一定是连续的，子数组可以是一个数也可以是多个数
// substring（子串）： 子串一定是连续的， 子串可以是一个字符也可以是多个字符