public class Container_With_Most_Water {
    /**
     * @param heights: a vector of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        // write your code here
        int left = 0, right = heights.length - 1;
        int capacity = 0;
        int result;

        while (left < right) {
            result = Math.min(heights[left], heights[right]) * (right - left);
            if (result > capacity) {
                capacity = result;
            }

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return capacity;
    }
}