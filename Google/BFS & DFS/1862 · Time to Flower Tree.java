Lintcode 1862 · Time to Flower Tree

public class Solution {
    /**
     * @param father: the father of every node
     * @param time: the time from father[i] to node i
     * @return: time to flower tree
     */
    public int timeToFlowerTree(int[] father, int[] time) {
        // construct the graph: father node -> children node
        Map<Integer, Set<Integer>> father2Children = new HashMap<>();
        for (int i = 0; i < father.length; i++) {
            father2Children.put(i, new HashSet<>());
        }

        for (int i = 1; i < father.length; i++) {
            father2Children.get(father[i]).add(i);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});  // node, time
       
        int totalTime = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node2Time = queue.poll(); 
                int currentNode = node2Time[0];
                int currentTime = node2Time[1];
                totalTime = Math.max(totalTime, currentTime); 
                for (int neighbor : father2Children.get(currentNode)) { 
                    queue.offer(new int[]{neighbor, currentTime + time[neighbor]});
                }
            }
        }
        return totalTime;
    }
}