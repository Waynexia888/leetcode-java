public class Solution {
    /**
     * @param heights: a list of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here
        if (heights == null || heights.length <= 2) {
            return 0;
        }

        // 从左往右走，找到最高的那个挡板，记录其对应的peakIndex,
        int peakIndex = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] > heights[peakIndex]) {
                peakIndex = i;
            }
        }

        int leftMostBar = 0;
        int water = 0;
        for (int i = 0; i < peakIndex; i++) {
            if (heights[i] > leftMostBar) {
                leftMostBar = heights[i];
            } else {
                water += leftMostBar - heights[i];
            }
        }

        int rightMostBar = 0;
        for (int i = heights.length - 1; i > peakIndex; i--) {
            if (heights[i] > rightMostBar) {
                rightMostBar = heights[i];
            } else {
                water += rightMostBar - heights[i];
            }
        }
        return water;
    }
}

