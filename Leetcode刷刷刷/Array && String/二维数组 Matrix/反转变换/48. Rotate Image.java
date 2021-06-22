// You are given an n x n 2D matrix representing an image, rotate the image by 90 
// degrees (clockwise).

// You have to rotate the image in-place, which means you have to modify the input 
// 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[7,4,1],[8,5,2],[9,6,3]]

class Solution {
    public void rotate(int[][] matrix) {
        // 主对角线反转 + 垂直方向反转
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len - 1 - j];
                matrix[i][len - 1 - j] = temp;
            }
        }
    }
}

// 本题思想：二维矩阵 - 反转变换
// 二维矩阵 - 反转变换有4种变换方法：
// 1. 左右反转（垂直方向反转）
// 2. 上下反转（水平方向反转）
// 3. 主对角线反转
// 4. 副对角线反转
// 本题解题方法有： 主 + 垂直；副 + 水平； 垂直 + 副； 水平 + 主
// 时间复杂度: O(n^2)
// 空间复杂度: O(1)
