public class Solution {
    /**
     * @param nums: an integer array
     * @param k:    An integer
     * @return: the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        // 维持一个size为k的最小堆
        // time: O(nlogk)
        int[] results = new int[k];
        if (nums == null || nums.length == 0 || k < 0) {
            return results;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Integer number : nums) {
            minHeap.offer(number);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        for (int i = 0; i < k; i++) {
            results[k - i - 1] = minHeap.poll();
        }
        return results;
    }
}