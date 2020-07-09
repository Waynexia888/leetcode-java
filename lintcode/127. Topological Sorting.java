/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // 算法描述：
        // 1. 统计每个点的入度
        // 2. 将每个入度为 0 的点放入队列（Queue）中作为起始节点
        // 3. 不断从队列中拿出一个点，去掉这个点的所有连边（指向其他点的边），其他点的相应的入度 - 1
        // 4. 一旦发现新的入度为 0 的点，丢回队列中
        
        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        
        if (graph == null) {
            return graph;
        }
        
        // 1. count indegree
        Map<DirectedGraphNode, Integer> indegree = getIndegree(graph);
        System.out.println(indegree);
        
        // 2. find out nodes that has 0 in-degree
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode node : graph) {
            if (indegree.containsKey(node)) {
                continue;
            }
            queue.offer(node);
            result.add(node);
        }
        System.out.println(queue);
        
        // 3. bfs
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode n : node.neighbors) {
                indegree.put(n, indegree.get(n) - 1);
                if (indegree.get(n) == 0) {
                    result.add(n);
                    queue.offer(n);
                }
            }
        }
        return result;
    }
    
    private Map<DirectedGraphNode, Integer> getIndegree(ArrayList<DirectedGraphNode> graph) {
        Map<DirectedGraphNode, Integer> map = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1);
                }
            }
        }
        return new HashMap<>(map);
    }
    
}