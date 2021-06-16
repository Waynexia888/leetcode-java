323. Number of Connected Components in an Undirected Graph

class Solution {
    public int countComponents(int n, int[][] edges) {
        // build the graph
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, graph, visited);
                count++;
            }
        }
        return count;
    }
    
    private void bfs(int i, Map<Integer, Set<Integer>> graph, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visited[i] = true;
        
        while (!queue.isEmpty()) {
            int n = queue.poll();
            for (int nei : graph.get(n)) {
                if (!visited[nei]) {
                    queue.offer(nei);
                    visited[nei] = true;
                }
            }
        }
    }
}

time: O(n + m) where n is the node number(vertex), m are the edges