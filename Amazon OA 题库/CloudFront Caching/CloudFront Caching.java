public class CloudFrontCaching {
    public static int connectedSum(int N, List<String> edges) {
        // build the graph
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            graph.put(i, new HashMap<>());
        }

        for (String edge : edges) {
            String[] arr = edge.trim().split(" ");
            int num0 = Integer.parseInt(arr[0]);
            int num1 = Integer.parseInt(arr[1])
            graph.get(num0).add(num1);
            graph.get(num1).add(num0);
        }

        boolean[] visited = new boolean[N + 1];
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                Set<Integer> neightbors = bfs(i, graph, visited); // total number of the neighbors of current node
                if (neighbors != null && neighbors.size() > 0) {
                    sum += (int) Math.ceil(Math.sqrt(neighbors.size()));
                }
            }
        }
        return sum;
    }

    private Set<Integer> bfs(int i, Map<Integer, Set<Integer>> graph, boolean[] visited) {
        Set<Integer> results = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visited[i] = true;
        results.add(i);

        while (!queue.isEmpty()) {
            int n = queue.poll();
            for (int nei : graph.get(n)) {
                if (!visited[nei]) {
                    queue.offer(nei);
                    visited[nei] = true;
                    results.add(nei);
                }
            }
        }
        return results;
    }
}

