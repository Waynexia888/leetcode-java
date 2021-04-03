public class Solution {
    /**
     * @param sticks: the length of sticks
     * @return: Minimum Cost to Connect Sticks
     */
    public int MinimumCost(List<Integer> sticks) {
        // time: O(nlog(n)); space: O(n)
        if (sticks == null || sticks.size() == 0) {
            return 0;
        }

        int result = 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int number : sticks) {
            minHeap.offer(number);
        }

        while (minHeap.size() >= 2) {
            int num1 = minHeap.poll();
            int num2 = minHeap.poll();
            int target = num1 + num2;
            minHeap.offer(target);
            result += target; 
        }   
        return result;     
    }
}

