Lintcode 1042 · Toeplitz Matrix

public class Solution {
    /**
     * @param matrix: the given matrix
     * @return: True if and only if the matrix is Toeplitz
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        // time: O(m * n); space; O(1)
        int rows = matrix.length;
        int columns = matrix[0].length;
        if (matrix == null || rows == 0 || matrix[0] == null || columns == 0) {
            return false;
        }

        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < columns - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}

// [1, 2, 3, 4]
// [5, 1, 2, 3]
// [9, 5, 1, 2]

// [1, 2]
// [2, 2]