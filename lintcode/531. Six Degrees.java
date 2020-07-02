/**
 * Definition for Undirected graph. class UndirectedGraphNode { int label;
 * List<UndirectedGraphNode> neighbors; UndirectedGraphNode(int x) { label = x;
 * neighbors = new ArrayList<UndirectedGraphNode>(); } };
 */

public class Solution {
    /*
     * @param graph: a list of Undirected graph node
     * 
     * @param s: Undirected graph node
     * 
     * @param t: Undirected graph nodes
     * 
     * @return: an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t) {
        // write your code here
        if (s == t) {
            return 0;
        }

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        queue.offer(s);
        set.add(s);
        int step = 0;
        if (s == t) {
            return step;
        }

        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode node = queue.poll();
                for (UndirectedGraphNode nei : node.neighbors) {
                    if (!set.contains(nei)) {
                        set.add(nei);
                        queue.offer(nei);
                        if (nei == t) {
                            return step;
                        }
                    }
                }
            }
        }
        return -1;
    }
}