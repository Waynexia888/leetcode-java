Lintcode 1565 · Modern Ludo I

public class Solution {
    /**
     * @param length: the length of board
     * @param connections: the connections of the positions
     * @return: the minimum steps to reach the end
     */
    public int modernLudo(int length, int[][] connections) {
        // Write your code here
        Map<Integer, Set<Integer>> graph = buildGraph(length, connections);
        Queue<Integer> queue =  new LinkedList<>();
        queue.offer(1);
        Map<Integer, Integer> distance = new HashMap<>(); 
        distance.put(1, 0);

        // 外层BFS求最短步数， 内层BFS找连通的点
        while (!queue.isEmpty()) {
            int node = queue.poll();  // 1
            int limit = Math.min(node + 7, length + 1);
            for (int neighbor = node + 1; neighbor < limit; neighbor++) {
                // 找到跟neighbors通过connections相连接的所有点，包含neighbor自己
                List<Integer> connectedNodes = getUnvisitedNodes(graph, distance, neighbor);
                for (int connectedNode : connectedNodes) {
                    if (connectedNode == length) {
                        return distance.get(node) + 1;
                    }
                    queue.offer(connectedNode);
                    distance.put(connectedNode, distance.get(node) + 1);
                }
            }
        }
        return distance.get(length);
    }
    
    // 找出当前neighbor通过connection相连接的所有unvisited点，包含neighbor自己
    private List<Integer> getUnvisitedNodes(Map<Integer, Set<Integer>> graph, 
                                            Map<Integer, Integer> distance, 
                                            int node) {
        List<Integer> unvisitedNodes = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            if (distance.containsKey(currentNode)) {
                continue;
            }
            unvisitedNodes.add(currentNode);
            for (int neighbor : graph.get(currentNode)) {
                if (!distance.containsKey(neighbor)) {
                    queue.offer(neighbor);
                    unvisitedNodes.add(neighbor);
                }
            }
        }
        return unvisitedNodes;
    }

    // construct a adjacency list, to store all connections
    private Map<Integer, Set<Integer>> buildGraph(int length, int[][] connections) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= length; i++) {
            graph.put(i, new HashSet<>());
        }

        for (int i = 0; i < connections.length; i++) {
            int from = connections[i][0];
            int to = connections[i][1];
            graph.get(from).add(to);
        }
        return graph;
    }
}