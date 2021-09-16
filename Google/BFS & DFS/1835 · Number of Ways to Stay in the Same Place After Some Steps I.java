Lintcode 1835 · Number of Ways to Stay in the Same Place After Some Steps I

public class Solution {
    /**
     * @param steps: steps you can move
     * @param arrLen: the length of the array
     * @return: Number of Ways to Stay in the Same Place After Some Steps
     */
    private int numWays = 0;
    public int numWays(int steps, int arrLen) {
        // write your code here
        dfs(steps, arrLen, 0, 0);
        return numWays;
    }

    private void dfs(int steps, int arrLen, int count, int index) {
        if (count == steps && index == 0) {
            numWays++;
            return;
        }

        if (index < 0 || index >= arrLen || count > steps) {
            return;
        }

        dfs(steps, arrLen, count + 1, index - 1);
        dfs(steps, arrLen, count + 1, index + 1);
        dfs(steps, arrLen, count + 1, index);
    }
}

// [1, 2, 3, 4]
//  i 
// time; O(3^(min(steps, arrLen))) = O(3^n)， 对于每一个位置，你有3种不同的走法