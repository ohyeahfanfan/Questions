package DP;

public class BestTimeToBuyAndSellStock {
	/*
	 * Best Time to Buy and Sell Stock
	 * Say you have an array for which the ith element is the price of a given stock on day i.
	 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
	 * design an algorithm to find the maximum profit. 
	 * 
	 * Find i and j that maximizes Aj ¨C Ai, where i < j.
	 * 
	 * Greedy?
	 * 
	 * MaxProfit(n) = Max{MaxProfit(n-1) + price[n] - min}
	 */
	public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        if(prices == null || prices.length == 0) return 0;
        for(int i = 0;  i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }
            int profit = prices[i] - min; 
            max = (profit > max ? profit: max);
        }
        return max;
    }
}
