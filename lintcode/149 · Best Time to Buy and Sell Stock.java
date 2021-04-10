public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        int result = 0;
        int minStock = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minStock) {
                minStock = prices[i];
            }

            // if (prices[i] - minStock > result) {
            //     result = prices[i] - minStock;
            // }
            result = Math.max(result, prices[i] - minStock);
        }
        return result;
    }
}

// currentPrice - ?? -> maxProfit
// ?? -> min
// 打个擂台