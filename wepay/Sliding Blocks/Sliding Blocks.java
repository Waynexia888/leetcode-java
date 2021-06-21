public static int test(int[][] in) {
    int m = in.length;
    int n = in[0].length;
    
    // compress the given M * N matrix to a source string
    String source = "";
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            source += String.valueOf(in[i][j]);
        }
    }

    // write a helper method, compress the solution matrix to a target string
    String target = getTargetString(in, m * n);

    Queue<String> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    queue.offer(source);
    visited.add(source);

    // BFS process
    int step = 0;
    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            String cur = queue.poll();
            if (cur.equals(target)) {
                return step;
            }
            // write a helper method getNext(), it should return a list of string
            for (String next : getNext(in, cur)) {
                if (!visited.contains(next)) {
                    queue.offer(next);
                    visited.add(next);
                }
            }
        }
        step++;
    }
    return -1;

}

public static String getTargetString(int[][] in, int lastIndex) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < lastIndex; i++) {
        sb.append(String.valueOf(i));
    }
    return sb.toString();
}

public List<String> getNext(int[][] in, String board) {
    List<String> results = new ArrayList<>();
    int m = in.length;
    int n = in[0].length;

    // four moving direction: up, down, right, left, 
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};

    int zeroIndex = board.indexOf('0');
    int rowIndex = zeroIndex / n; 
    int columnIndex = zeroIndex % n;

    for (int k = 0; k < 4; k++) {
        int nx = rowIndex + dx[k];
        int ny = columnIndex + dy[k];
        if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
            continue;
        }
        String next = swap(board, zeroIndex, nx * n + y);
        results.add(next);
    }
    return results;
}

public static String swap(String s, int i, int j) {
    char[] arr = s.toCharArray();
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
    return new String(arr);
}

// Leetcode 773
// time: O(M * N *(M * N)!), M行数， N列数, 最多有O((M * N)!) 种可能的棋盘状态
// space: O(M * N *(M * N)!)