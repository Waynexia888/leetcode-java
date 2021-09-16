Lintcode 4 · Ugly Number II

public class Solution {
    /**
     * @param n: An integer
     * @return: return a  integer as description.
     */
    public int nthUglyNumber(int n) {
        // write your code here
        int[] primeFactors = new int[]{2, 3, 5};
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        minHeap.offer(1L);
        Set<Long> visited = new HashSet<>();
        visited.add(1L);

        for (int i = 1; i < n; i++) {
            long number = minHeap.poll();
            for (int factor : primeFactors) {
                long uglyNumber = number * factor;
                if (!visited.contains(uglyNumber)) {
                    minHeap.offer(uglyNumber);
                    visited.add(uglyNumber);
                }
            }
        }
        long ans = minHeap.poll();
        return (int)ans;
    }
}
// Set<1, 2, 3, 5, 4, 6, 10, 9, 15, 8, 25, 18, 30, 16, 24, 40, 27, 45>
// minHeap =  {10, 12, 15, 16, 18, 20, 24, 25, 27, 30, 40, 45}
// 1, 2, 3, 4, 5, 6, 8, 9, 

