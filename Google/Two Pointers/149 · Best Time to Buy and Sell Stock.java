Lintcode 149 · Best Time to Buy and Sell Stock

public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int profit = 0, min = Integer.MAX_VALUE;
        for (int price : prices) {
            min = Math.min(min, price);     
            profit = Math.max(profit, price - min); 
        }
        return profit;
    }
}
