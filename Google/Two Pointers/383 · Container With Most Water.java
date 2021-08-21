Lintcode 383 · Container With Most Water
Leetcode 11. Container With Most Water

class Solution {
    public int maxArea(int[] height) {
        // time: O(n), space: O(1)
        if (height == null || height.length < 2) {
            return 0;
        }
        
        int left = 0, right = height.length - 1;
        int water = 0;
        int min = 0;
        while (left < right) {
            min = Math.min(height[left], height[right]);
            water = Math.max(water, min * (right - left));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return water;
    }
}

// water = min(leftMax, rightMax) * (right - left)
// 随着(right - left) 即x轴不断减小， y轴应该尽可能的增大
// 所以left，right指针如何移动，取决于最大的y轴