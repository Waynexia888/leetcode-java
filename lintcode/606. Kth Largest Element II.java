public class Solution {
    /**
     * @param nums: an integer unsorted array
     * @param k:    an integer from 1 to n
     * @return: the kth largest element
     */
    public int kthLargestElement2(int[] nums, int k) {
        // 求第k大元素， 那么就把数组中元素全部放入堆，维持一个size为k的最小堆
        // time: O(nlogk)
        if (nums == null || nums.length == 0 || k < 0) {
            return -1;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Integer number : nums) {
            minHeap.offer(number);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}