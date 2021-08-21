Leetcode 42. Trapping Rain Water
Lintcode 363 · Trapping Rain Water

class Solution {
    public int trap(int[] height) {
        // time: O(n); space: O(1)
        if (height == null || height.length <= 2) {
            return 0;
        }
        
        // find the index of the max height of the bar.
        int maxHeightIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[maxHeightIndex]) {
                maxHeightIndex = i;
            }
        }
        
        // find how much it can trap between index 0 and maxHeightIndex
        int water = 0;
        int maxLeft = 0;
        for (int i = 0; i < maxHeightIndex; i++) {
            if (height[i] > maxLeft) {
                maxLeft = height[i];
            } else {   // trap the water here
                water += maxLeft - height[i];
            }
        }
        
        System.out.print(water);
        // find how much it can trap between index height.length - 1 and maxHeightIndex
        int maxRight = 0;
        for (int i = height.length - 1; i > maxHeightIndex; i--) {
            if (height[i] > maxRight) {
                maxRight = height[i];
            } else {    // trap water here
                water += maxRight - height[i];
            }
        }
        return water;
    }
}

// how to trap water?
// water = min(maxLeftBar, maxRightBar) - current Bar Height


       