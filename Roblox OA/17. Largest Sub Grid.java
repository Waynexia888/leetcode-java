You are given an integer square grid which can be divided into square sub-grids. 
the sub-grid sum is obtained by adding all elements of the sub-grid. Determine 
the maximum size of a square sub-grid such that all sub-grids of this size must
have sub-grid sum less than or equal to a given value (maxSum). return the size 
of that sub-grid (size = number of rows or columns).

example:
A 4 x 4 grid is provided.
grid = [[1, 1, 1, 1],
        [2, 2, 2, 2],
        [3, 3, 3, 3],
        [4, 4, 4, 4]]
maxSum: 39

the maximum sum of a 3 x 3 sub-grid is 27 and for 4 x 4 is 40

给一个grid 和 maxSum，求最大边长k，使grid中所有k * k subgrid的sum都<maxSum

// https://leetcode.jp/leetcode-1292-maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold-%e8%a7%a3%e9%a2%98%e6%80%9d%e8%b7%af%e5%88%86%e6%9e%90/