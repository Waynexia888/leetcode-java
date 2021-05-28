class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        
        int index1 = findFirstIndexOfTarget(nums, target);
        int index2 = findLastIndexOfTarget(nums, target);
        return new int[]{index1, index2};    
    }
    
    private int findFirstIndexOfTarget(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
    
    private int findLastIndexOfTarget(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (nums[end] == target) {
            return end;
        }
        if (nums[start] == target) {
            return start;
        }
        return -1;
    }
}