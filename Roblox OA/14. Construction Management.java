// A construction company is building a new neighborhood, and they are currently 
// working on the design. Each house will be built using one of three main 
// materials(e.g. wood, brick, or concrete), but no side-by-side houses can be 
// made of the same material. Because each house will be varying size and complexity,
// the cost of the materials for each house varies. Given the cost of using each 
// material for each house, what is the minimum cost needed to complete the neighborhood?

// for example, let's say there are n = 3 houses to be built, also,
// cost = [[1, 2, 3], [1, 2, 3], [3, 3, 1]], denoting the cost of materials for 
// each of the 3 houses. The minimum cost to build all the houses is 4, as seen below:

// For the first house, the cheapest material is the first one, which costs 1.
// For the second house, the materials cost the same as with the first house, 
// but the same material can't be used because the houses are side by side.
// The next best option is the second material, which costs 2. Finally, the cheapest
// material for the third house is the third material, which costs 1.
// Therefore, the total cost to build all the houses is 1 + 2 + 1 = 4.

// costs[i][j]; i: house; j: material

// dynamic programming
// similar to leetcode 256 Paint House
// time: O(n)
// space: O(1)

public int minCost(int[][] costs) {
    if (costs == null || costs[0].length == 0) {
        return 0;
    }

    for (int i = 1; i < costs.length; i++) {
        costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
        costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
        costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
    }

    int n = costs.length - 1;
    return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
}