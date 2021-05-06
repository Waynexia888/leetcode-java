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

//////////////////////////////////////////////////////////////
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
        // write your code here
        ArrayList<DirectedGraphNode> results = new ArrayList<>();
        if (graph == null) {
            return results;
        }

        // 1. use HashMap tp count in-degree
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

        // 2. find out nodes that has 0-indegree, and put it into queue
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                queue.offer(node);
            }
        }

        // 3. bfs
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            results.add(node);
            for (DirectedGraphNode nei : node.neighbors) {
                map.put(nei, map.get(nei) - 1);
                if (map.get(nei) == 0) {
                    queue.offer(nei);
                }
            }
        }
        return results;
    }
}

////////////////////////////////////////////////////////////////
/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     List<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * }
 */

public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> results = new ArrayList<>();

        // using hashmap to count in-degree
        Map<DirectedGraphNode, Integer> map = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode nei : node.neighbors) {
                map.put(nei, map.getOrDefault(nei, 0) + 1);
            }
        }
        
        // find node with in-degree = 0, and put it into queue
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                queue.offer(node);
            }
        }

        // bfs 
        while (!queue.isEmpty()) {
            DirectedGraphNode n = queue.poll();
            results.add(n);
            for (DirectedGraphNode nei : n.neighbors) {
                map.put(nei, map.get(nei) - 1);
                if (map.get(nei) == 0) {
                    queue.offer(nei);
                }
            } 
        }

        return results;
    }
}