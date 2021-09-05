Leetcode 1844 · subarray sum equals to k II

public class Solution {
    /**
     * @param nums: a list of integer
     * @param k: an integer
     * @return: return an integer, denote the minimum length of continuous subarrays whose sum equals to k
     */
    public int subarraySumEqualsKII(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>(); // prefixSum, prefixSum Index
        map.put(0, 0);
        int minSize = Integer.MAX_VALUE;
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (map.containsKey(prefixSum - k)) {
                int length = i + 1 - (map.get(prefixSum - k));
                minSize = Math.min(minSize, length);
            }
            map.put(prefixSum, i + 1);
        }
        return minSize == Integer.MAX_VALUE ? -1 : minSize;
    }
}

// follow up: 如何求和为k的最长子数组？

public class Solution {
    /**
     * @param nums: a list of integer
     * @param k: an integer
     * @return: return an integer, denote the minimum length of continuous subarrays whose sum equals to k
     */
    public int subarraySumEqualsKII(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>(); // prefixSum, prefixSum Index
        map.put(0, 0);
        int maxSize = Integer.MIN_VALUE;
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (map.containsKey(prefixSum - k)) {
                int length = i + 1 - (map.get(prefixSum - k));
                maxSize = Math.max(maxSize, length);
            }
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i + 1);
            }
        }
        return maxSize == Integer.MIN_VALUE ? -1 : maxSize;
    }
}

