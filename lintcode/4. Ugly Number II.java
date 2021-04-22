public class Solution {
    /**
     * @param n: An integer
     * @return: return a  integer as description.
     */
    public int nthUglyNumber(int n) {
        // time: O(nlogn);  minHeap + hashSet
        // space: O(n)
        // 注意：本题最小堆需要使用Long这种整型type
        
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Set<Long> visited = new HashSet<>();
        long ugly = 1;
        minHeap.offer(1L);
        visited.add(1L);
        int[] primeFactors = new int[]{2, 3, 5};
        
        for (int i = 0; i < n; i++) {
            ugly = minHeap.poll();
            for (Integer factor : primeFactors) {
                long newUgly = ugly * factor;
                if (!visited.contains(newUgly)) {
                    minHeap.offer(newUgly);
                    visited.add(newUgly);
                }
            }
        }
        return (int)ugly;
    }
}