// Given an array of size n, find the majority element. The majority element is 
// the element that appears more than ⌊ n/2 ⌋ times.

// You may assume that the array is non-empty and the majority element always exist 
// in the array.

// Example 1:

// Input: [3,2,3]
// Output: 3
// Example 2:

// Input: [2,2,1,1,1,2,2]
// Output: 2

class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int majorityCount = nums.length / 2;
        
        for (int num : nums) {
            int count = 0;
            for (int number : nums) {
                if (num == number) {
                    count++;
                }
            }
            
            if (count > majorityCount) {
                return num;
            }
        }
        return -1; 
    }
}

// 暴力解法
// 时间复杂度: O(n^2)
// 空间复杂度: O(1)

//////////////////////////////////////////////////////////////////////

class Solution {
    public int majorityElement(int[] nums) {
        
        int count = 0;
        Integer candidate = null;
        
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            
            if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
        
    }
}

// 本题思想： 数组 - 数学定理
// 每次都找出一对不同的元素，从数组中删掉，直到数组为空或只有一种元素
// 不难证明， 如果存在元素e出现频率超过半数，那么数组中最后剩下的就只有e
// 时间复杂度: O(n)
// 空间复杂度: O(1)