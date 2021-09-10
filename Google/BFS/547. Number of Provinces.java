Leetcode 547. Number of Provinces
1179 · Friend Circles

class Solution {
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }
        
        if (isConnected[0] == null || isConnected[0].length == 0) {
            return 0;
        }
        
        int provinces = 0;
        int n = isConnected.length; // n cities
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            bfs(isConnected, i, visited);
            provinces++;
        }
        return provinces;
    }
    
    private void bfs(int[][] isConnected, int i, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visited[i] = true;
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[cur][j] == 1 && !visited[j]) {
                    queue.offer(j);
                    visited[j] = true;
                }
            }
        }
    }
}

////////////////////////////////////////////////////////
class Solution {
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }
        
        if (isConnected[0] == null || isConnected[0].length == 0) {
            return 0;
        }
        
        int provinces = 0;
        int n = isConnected.length; // n cities
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            dfs(isConnected, i, visited);
            provinces++;
        }
        return provinces;
    }
    
    private void dfs(int[][] isConnected, int i, boolean[] visited) {
      
        visited[i] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                dfs(isConnected, j, visited);
            }
        }
    }
}