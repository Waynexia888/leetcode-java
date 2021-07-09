class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n]; // default value = 0
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (colors[i] != 0) {
                continue;
            } 
            
            // color node i
            queue.offer(i);
            colors[i] = 1;
            
            // bfs
            while (!queue.isEmpty()) {
                int currentNode = queue.poll();
                for (int neighbor : graph[currentNode]) {
                    if (colors[neighbor] == 0) {
                        colors[neighbor] = -colors[currentNode];
                        queue.offer(neighbor);
                    }
                    
                    if (colors[neighbor] == colors[currentNode]) {
                        return false;
                    }
                }
            }  
        }
        return true;
    }
}

