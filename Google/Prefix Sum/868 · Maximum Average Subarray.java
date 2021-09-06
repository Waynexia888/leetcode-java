Lintcode 868 · Maximum Average Subarray

public class Solution {
    /**
     * @param nums: an array
     * @param k: an integer
     * @return: the maximum average value
     */
    public double findMaxAverage(int[] nums, int k) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        double results = Double.MIN_VALUE;
        for (int i = 0; i < nums.length - k + 1; i++) {
            double avg = ((prefixSum[i + k] - prefixSum[i]) / (k * 1.0));
            if (avg > results) {
                results = avg;
            }
        }
        return results;
    }
}