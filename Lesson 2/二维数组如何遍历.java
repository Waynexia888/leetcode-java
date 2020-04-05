// 二维数组如何遍历？

int[][] matrix = new int[][] {
    {10, 20, 30},
    {10, 30},
    {1, 2, 3, 4, 5}
};


for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.println(matrix[i][j]);

    }
}