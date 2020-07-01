/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

public class Solution {
    /*
     * @param nodes: a array of Undirected graph node
     * 
     * @return: a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
        // 遍历nodes的时间复杂度O(N) + 排序O(nlogn) = O(nlogn)
        // 题目要求返回的是一个排好序的
        List<List<Integer>> results = new ArrayList<>();
        if (nodes == null) {
            return results;
        }

        Set<UndirectedGraphNode> set = new HashSet<>();
        for (UndirectedGraphNode node : nodes) {
            if (!set.contains(node)) {
                bfs(node, results, set);
            }
        }
        return results;
    }

    private void bfs(UndirectedGraphNode node, List<List<Integer>> results, Set<UndirectedGraphNode> set) {
        List<Integer> component = new ArrayList<>();

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        set.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            component.add(head.label);
            for (UndirectedGraphNode nei : head.neighbors) {
                if (!set.contains(nei)) {
                    set.add(nei);
                    queue.offer(nei);
                }
            }
        }
        Collections.sort(component);
        results.add(component);
    }
}