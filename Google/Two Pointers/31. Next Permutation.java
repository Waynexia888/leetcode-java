Leetcode 31. Next Permutation
class Solution {
    public void nextPermutation(int[] nums) {
        // find the first decreasing one from right to left
        int index = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                index = i - 1;
                break;
            }
        }
        
        // eg: [3, 2, 1]
        if (index == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        
        // find the first bigger one
        for (int i = nums.length - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                swap(nums, index, i);
                break;
            }
        }
        reverse(nums, index + 1, nums.length - 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}

// given: [1, 2, 3, 6, 5, 4]
// 1st step: from right to left, find index of first decreasing, which is index = 2, number is 3
// 2nd step: find the bigger number than 3, which is number = 4, then swap 3 and 4 position
//           it becomes: [1, 2, 4, 6, 5, 3]
// 3rd step: reverse [6, 5, 3] this part, it becomes: [1, 2, 4, 3, 5, 6]