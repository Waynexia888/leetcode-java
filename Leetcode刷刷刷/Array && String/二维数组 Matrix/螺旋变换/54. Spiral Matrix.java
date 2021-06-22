// Given a matrix of m x n elements (m rows, n columns), return all elements of 
// the matrix in spiral order.

// Example 1:

// Input:
// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]
// Output: [1,2,3,6,9,8,7,4,5]
// Example 2:

// Input:
// [
//   [1, 2, 3, 4],
//   [5, 6, 7, 8],
//   [9,10,11,12]
// ]
// Output: [1,2,3,4,8,12,11,10,9,5,6,7]

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> results = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return results;
        }
        
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; i++) {
                results.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            
            for (int i = rowBegin; i <= rowEnd; i++) {
                results.add(matrix[i][colEnd]);
            }
            colEnd--;
            
            if (rowBegin <= rowEnd) { //因为rowBegin++，这里这么做的原因是避免越界
                for (int i = colEnd; i >= colBegin; i--) {
                    results.add(matrix[rowEnd][i]);
                }
            }  
            rowEnd--;
            
            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    results.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }
        return results;
    }
}

// 本题思路：二维矩阵 - 旋转变换
// 本题是旋转变换的原型题，需要理解背诵
// 时间复杂度: O(n)
// 空间复杂度: O(n)