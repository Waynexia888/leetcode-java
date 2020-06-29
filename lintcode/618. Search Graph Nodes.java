/**
 * Definition for graph node. class UndirectedGraphNode { int label;
 * ArrayList<UndirectedGraphNode> neighbors; UndirectedGraphNode(int x) { label
 * = x; neighbors = new ArrayList<UndirectedGraphNode>(); } };
 */

public class Solution {
    /*
     * @param graph: a list of Undirected graph node
     * 
     * @param values: a hash mapping, <UndirectedGraphNode, (int)value>
     * 
     * @param node: an Undirected graph node
     * 
     * @param target: An integer
     * 
     * @return: a node
     */
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
            Map<UndirectedGraphNode, Integer> values, UndirectedGraphNode node, int target) {
        // BFS + HashSet
        // edge case 判断， 这里target 不能等于null， 因为target是int整型
        if (graph == null || values == null || node == null) {
            return null;
        }

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();

        queue.offer(node);
        set.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            if (values.get(head) == target) {
                return head;
            }

            for (UndirectedGraphNode neighbor : head.neighbors) {
                if (!set.contains(neighbor)) {
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return null;
    }
}