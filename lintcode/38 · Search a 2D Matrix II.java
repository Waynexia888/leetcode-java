public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        int m = matrix.length;
        int n = matrix[0].length;
        if (matrix == null || m == 0 || matrix[0] == null || n == 0) {
            return 0;
        }

        int x = m - 1;
        int y = 0;
        int result = 0;
        while (x >= 0 && y < n) {
            if (matrix[x][y] == target) {
                result++;
                x--;
                y++;
            } else if (matrix[x][y] > target) {
                x--;
            } else {
                y++;
            }
        }
        return result;
    }
}

// 从左下角(m - 1, 0) 这个位置开始搜索
// 如果该点的值 > target, 就去上面搜(m - 2, 0)
// 如果该点的值 < target, 就去右边搜(m - 1, 1)
// 如果该点的值 == target, 就去右上角搜(m - 2, 1)
// time: O(m + n); space: O(1)
// 当然也可以从右上角(0, n - 1)这个位置开始搜索