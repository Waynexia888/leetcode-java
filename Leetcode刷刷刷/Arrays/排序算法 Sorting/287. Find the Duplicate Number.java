// Given an array nums containing n + 1 integers where each integer is between 
// 1 and n (inclusive), prove that at least one duplicate number must exist. 
// Assume that there is only one duplicate number, find the duplicate one.

// Example 1:

// Input: [1,3,4,2,2]
// Output: 2
// Example 2:

// Input: [3,1,3,4,2]
// Output: 3
// Note:

// 1. You must not modify the array (assume the array is read only).
// 2. You must use only constant, O(1) extra space.
// 3. Your runtime complexity should be less than O(n2).
// 4. There is only one duplicate number in the array, but it could be repeated 
// more than once.

class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }
}

// 基于排序，排序后，相邻的重复元素就能快速找到
// 时间复杂度: O(nlogn)
// 空间复杂度: O(1) or O(n)
// Here, we sort nums in place, so the memory footprint is constant. 
// If we cannot modify the input array, then we must allocate linear 
// space for a copy of nums and sort that instead.


/////////////////////////////////////////////////////////////////////////////

class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }
}

// 使用哈希表来解决重复元素问题
// 时间复杂度: O(n)
// 空间复杂度: O(n)

////////////////////////////////////////////////////////////////////////

class Solution {
    public int findDuplicate(int[] nums) {
        // slow 走一步， fast走两步
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // 当while循环结束后， 即slow和fast相遇
        // 此时slow走一步， fast走一步
        
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}

// 本题同 142: linked list cycle II 思想相同
// 时间复杂度: O(n)
// 空间复杂度: O(1)


