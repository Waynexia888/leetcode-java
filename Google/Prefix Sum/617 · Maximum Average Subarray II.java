Lintcode 617 · Maximum Average Subarray II

public class Solution {
    /**
     * @param nums: an array with positive and negative numbers
     * @param k: an integer
     * @return: the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // avg 最小就是当 子数组长度为1的时候，即在nums里找min
        double start = 0, end = 0;
        for (int n : nums) {
            start = Math.min(start, n);
            end = Math.max(end, n);
        }

        double esp = 1e-5;
        while (start + esp < end) {
            double mid = start + (end - start) / 2.0;
            if (check(nums, mid, k)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private boolean check(int[] nums, double avg, int k) {
        double sum = 0, prevSum = 0, minPrev = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i] - avg;
        } 
        // up to here, sum is the average subarray with length k = 4
        if (sum >= 0) {
            return true;
        }

        // now check the length k > 4
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - avg;
            prevSum += nums[i - k] - avg;
            minPrev = Math.min(minPrev, prevSum);
            if (sum - minPrev >= 0) {
                return true;
            }
        }
        return false;
    }
}

// (1 + 2 + 3) / 3 = 2
// => (1 - 2 + 2 - 2 + 3 - 2) >= 0
// 因此，对于原数组，每个数减去avg，然后找一个子数组的和 >= 0, 且需要满足长度 >= k
// 所以需要用二分法不断的找出avg的最值
