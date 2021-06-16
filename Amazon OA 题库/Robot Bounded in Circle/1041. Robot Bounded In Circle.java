1041. Robot Bounded In Circle

class Solution {
    public boolean isRobotBounded(String instructions) {
        // time: O(n); space: O(1)
        int a = 0, b = 0;
        int dir = 0; // 0 -> N, 1 -> E, 2 -> S, 3 -> W
        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        for (int i = 0; i < instructions.length(); i++) {
            char c = instructions.charAt(i);
            if (c == 'G') {
                a = a + directions[dir][0];
                b = b + directions[dir][1];
            } else if (c == 'L') {
                dir = (dir == 0) ? 3 : (dir - 1);
            } else if (c == 'R') {
                dir = (dir + 1) % 4;
            }
        }
        
        if (a == 0 && b == 0) {
            return true;
        }
        
        if (dir == 0) {
            return false;
        }
        // dir = 1, 2, 3
        return true;
    }
}