// totalProfit = totalUniformRods x saleLength x salePrice - totalCuts x costPerCut

// Example: lengths = [30, 59, 110], salePrice = 10, costPerCut = 1
// Length      Rod     Pieces     Cuts
// 30          30        1         0
//             59        1         1
//             110       3         3
// Revenue = (5 x 30 x 10) - (4 x 1) = 1496
// ------------------------------------------
// Length      Rod     Pieces     Cuts
// 15          30        2         1
//             59        3         3
//             110       7         7
// Revenue = (12 x 15 x 10) - (11 x 1) = 1789
// ------------------------------------------
// Length      Rod     Pieces     Cuts
// 10          30        3         2
//             59        5         5
//             110       11        10
// Revenue = (19 x 10 x 10) - (17 x 1) = 1883
// ------------------------------------------
// Length      Rod     Pieces     Cuts
// 6           30        5         4
//             59        9         9
//             110       18        18
// Revenue = (32 x 6 x 10) - (31 x 1) = 1889
// ------------------------------------------
// Length      Rod     Pieces     Cuts
// 5           30        6         5
//             59        11        11
//             110       22        21
// Revenue = (39 x 5 x 10) - (37 x 1) = 1913
// ------------------------------------------
// Length      Rod     Pieces     Cuts
// 3           30        10         9
//             59        19        19
//             110       36        36
// Revenue = (65 x 3 x 10) - (64 x 1) = 1886



public static int maxProfit(int costPerCut, int salePrice, List<Integer> lengths) {
    if (lengths ==  null || lengths.size() == 0) {
        return 0;
    }

    int profit = 0;
    int maxLength = 0;
    for (Integer length : lengths) {
        maxLength = Math.max(maxLength, length);
    }

    for (int L = 1; L <= maxLength; L++) {
        int cuts = 0; pieces = 0;
        for (Integer length : lengths) {
            int currentPieces = length / L;
            int currentCuts = (length - 1) / L;
            if (currentPieces * L * salePrice - currentCuts * costPerCut > 0) {
                cuts += currentCuts;
                pieces += currentPieces;
            }
        }
        profit = Math.max(profit, pieces * L * salePrice - cuts * costPerCut);
    }
    return profit;
}

// time: O(n^2);
// space: O(1)