// On the Qixi Festival, the Cowherd and the Weaver play together in a maze size of 
// n*m . However, they get separated from each other. Now given the maze consisting 
// of .,*,S,T, where . denotes an empty space, * denotes an obstacle, S denotes the 
// position of the cowherd, T denotes the position of the weaver, the Cowherd and 
// the Weaver will try to find each other(they can move to the grid up or down or 
// left or right or stand still, but they can't walk outside of the maze or move 
// to obstacles).Is it possible for them reunion? If possible, return True, otherwise 
// return False.

// Example
// Example 1:

// Input: 
// [
// "S..*",
// "*.**",
// "...T"
// ]
// Output: true
// Explanation:
// weaver don't need to move
// Cowherd's route:(0,0)->(0,1)->(1,1)->(2,1)->(2,2)->(2,3)
// Example 2:

// Input:
// [
// "S..*",
// "***.",
// "...T"
// ]
// Output: false
// Explanation
// It is impossible for them to reunion
// Notice
// 2<=n,m<=1000

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public boolean findHer(String[] maze) {
    int[] dx = new int[]{0, 0, -1, 1};
    int[] dy = new int[]{1, -1, 0, 0};

    int rows = maze.length;
    int columns = maze[0].length();


    Queue<Point> queue = new LinkedList<>();
    boolean[][] visited = new boolean[rows][columns];

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
            if (maze[i].charAt(j) == "S") {
                queue.offer(new Point(i, j));
                visited[i][j] = true;
            }
        }
    }

    while (!queue.isEmpty()) {
        Point point = queue.poll();
        for (int k = 0; k < 4; k++) {
            int nx = point.x + dx[k];
            int ny = point.y + dy[k];
            if (maze[nx].charAt(ny) == "T") {
                return true;
            }

            if (nx >= 0 && nx < rows && ny >= 0 && ny < columns && maze[nx].charAt(ny) == "." && !visited[nx][ny]) {
                queue.offer(new Point(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }
    return false;
}
